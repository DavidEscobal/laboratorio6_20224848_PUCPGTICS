package org.example.lab6_20224848.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String hashEnBD = "$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6";

        System.out.println("=== TEST DE CONTRASEÑA ===");
        System.out.println("Hash en BD: " + hashEnBD);

        boolean matches = encoder.matches("123456", hashEnBD);
        System.out.println("¿'123456' coincide? " + matches);

        if (!matches) {
            System.out.println("=== GENERANDO NUEVO HASH ===");
            String nuevoHash = encoder.encode("123456");
            System.out.println("Nuevo hash para '123456': " + nuevoHash);
            System.out.println("¿Coincide con el nuevo hash? " + encoder.matches("123456", nuevoHash));
        }
    }
}