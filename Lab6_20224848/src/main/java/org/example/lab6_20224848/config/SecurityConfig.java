package org.example.lab6_20224848.config;

import jakarta.servlet.http.HttpSession;
import org.example.lab6_20224848.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    private final DataSource dataSource;
    private final UsuarioRepository usuarioRepository;

    public SecurityConfig(DataSource dataSource, UsuarioRepository usuarioRepository) {
        this.dataSource = dataSource;
        this.usuarioRepository = usuarioRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

        String sqlAuth = "SELECT correo, password, 1 as enabled FROM usuarios WHERE correo = ?";
        String sqlAuto = "SELECT u.correo, r.nombre FROM usuarios u INNER JOIN roles r ON u.rol_id = r.id WHERE u.correo = ?";

        users.setUsersByUsernameQuery(sqlAuth);
        users.setAuthoritiesByUsernameQuery(sqlAuto);
        return users;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        // Públicas (sin login) - Visitantes pueden acceder
                        .requestMatchers("/", "/heroes", "/css/**", "/js/**", "/login").permitAll()

                        // Solo Admin
                        .requestMatchers("/heroes/admin/**", "/admin/**").hasAuthority("ADMIN")

                        // Usuarios autenticados (cualquier rol)
                        .requestMatchers("/intenciones/**", "/juegos/**", "/reservas/**").authenticated()

                        // Cualquier otra ruta requiere autenticación
                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/submitLoginForm")
                        .successHandler((request, response, authentication) -> {
                            // Si venías de una URL protegida, respeta la SavedRequest
                            DefaultSavedRequest defaultSavedRequest =
                                    (DefaultSavedRequest) request.getSession()
                                            .getAttribute("SPRING_SECURITY_SAVED_REQUEST");

                            // Guardar el objeto Usuario en sesión
                            HttpSession session = request.getSession();
                            session.setAttribute("USUARIO",
                                    usuarioRepository.findByCorreo(authentication.getName()));

                            if (defaultSavedRequest != null) {
                                String targetURL = defaultSavedRequest.getRequestURL();
                                new DefaultRedirectStrategy().sendRedirect(request, response, targetURL);
                                return;
                            }

                            // Redirección por rol
                            String rol = authentication.getAuthorities().stream()
                                    .map(GrantedAuthority::getAuthority)
                                    .findFirst().orElse("");

                            if ("ADMIN".equals(rol)) {
                                response.sendRedirect("/heroes/admin");
                            } else {
                                response.sendRedirect("/heroes");
                            }
                        })
                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true)
                );

        return http.build();
    }
}