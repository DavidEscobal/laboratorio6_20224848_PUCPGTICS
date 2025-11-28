package org.example.lab6_20224848.controller;

import org.example.lab6_20224848.entity.Intencion;
import org.example.lab6_20224848.entity.Usuarios;
import org.example.lab6_20224848.repository.IntencionRepository;
import org.example.lab6_20224848.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/intenciones")
public class IntencionController {

    @Autowired
    private IntencionRepository intencionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final List<String> palabrasProhibidas = Arrays.asList("odio", "pelea", "violencia", "matar");

    // Vista para USUARIOS - registrar intenciones
    @GetMapping
    public String mostrarFormulario(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuarios usuario = usuarioRepository.findByCorreo(auth.getName()); // ← CORREGIDO: Usuarios

        // Verificar si ya tiene una intención hoy
        long intencionesHoy = intencionRepository.countByUsuarioToday(usuario.getId());
        if (intencionesHoy > 0) {
            model.addAttribute("error", "Ya has registrado una intención hoy. Solo se permite una por día.");
        }

        // Obtener intenciones anteriores del usuario
        List<Intencion> intencionesUsuario = intencionRepository.findIntencionesByUsuarioId(usuario.getId());
        model.addAttribute("intenciones", intencionesUsuario);
        model.addAttribute("intencion", new Intencion());

        return "publico/intenciones-formulario"; // ← En publico
    }

    // Procesar la intención (USUARIOS)
    @PostMapping("/registrar")
    public String registrarIntencion(@ModelAttribute Intencion intencion,
                                     RedirectAttributes redirectAttributes) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuarios usuario = usuarioRepository.findByCorreo(auth.getName()); // ← CORREGIDO: Usuarios

        // Validaciones
        if (intencion.getDescripcion() == null || intencion.getDescripcion().trim().length() < 15) {
            redirectAttributes.addFlashAttribute("error", "La descripción debe tener al menos 15 caracteres");
            return "redirect:/intenciones";
        }

        // Validar palabras prohibidas
        String descripcionLower = intencion.getDescripcion().toLowerCase();
        for (String palabra : palabrasProhibidas) {
            if (descripcionLower.contains(palabra)) {
                redirectAttributes.addFlashAttribute("error",
                        "La descripción contiene palabras no permitidas");
                return "redirect:/intenciones";
            }
        }

        // Verificar límite de una intención por día
        long intencionesHoy = intencionRepository.countByUsuarioToday(usuario.getId());
        if (intencionesHoy > 0) {
            redirectAttributes.addFlashAttribute("error", "Ya has registrado una intención hoy");
            return "redirect:/intenciones";
        }

        // Guardar la intención
        intencion.setUsuarios(usuario);
        intencionRepository.save(intencion);

        redirectAttributes.addFlashAttribute("mensaje", "Intención registrada exitosamente");
        return "redirect:/intenciones";
    }

    // Vista para ADMIN - ver todas las intenciones
    @GetMapping("/admin")
    public String verTodasIntenciones(Model model) {
        List<Intencion> intenciones = intencionRepository.findAllByOrderByFechaDesc();
        model.addAttribute("intenciones", intenciones);
        return "admin/intenciones-admin";
    }
}