package org.example.lab6_20224848.controller;

import org.example.lab6_20224848.entity.HeroeNaval;
import org.example.lab6_20224848.repository.HeroeNavalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/heroes")
public class HeroeNavalController {

    @Autowired
    private HeroeNavalRepository heroeNavalRepository;


    @GetMapping
    public String listarHeroes(Model model) {
        List<HeroeNaval> heroes = heroeNavalRepository.findAll();
        model.addAttribute("heroes", heroes);
        return "publico/heroes"; // ← Ahora apunta a publico/heroes.html
    }


    @GetMapping("/admin")
    public String administrarHeroes(Model model) {
        List<HeroeNaval> heroes = heroeNavalRepository.findAll();

        if (!model.containsAttribute("nuevoHeroe")) {
            model.addAttribute("nuevoHeroe", new HeroeNaval());
        }

        model.addAttribute("heroes", heroes);
        return "admin/heroes-admin";
    }


    @PostMapping("/admin/registrar")
    public String registrarHeroe(@ModelAttribute("nuevoHeroe") HeroeNaval heroeNaval,
                                 BindingResult bindingResult,
                                 Model model) {

        // Validaciones
        if (heroeNaval.getNombre() == null || heroeNaval.getNombre().trim().isEmpty()) {
            bindingResult.rejectValue("nombre", "error.nuevoHeroe", "El nombre es obligatorio");
        }

        if (bindingResult.hasErrors()) {
            List<HeroeNaval> heroes = heroeNavalRepository.findAll();
            model.addAttribute("heroes", heroes);
            model.addAttribute("mensaje", "Por favor corrija los errores del formulario");
            model.addAttribute("tipoMensaje", "error");
            return "admin/heroes-admin";
        }

        try {
            heroeNavalRepository.save(heroeNaval);
            model.addAttribute("mensaje", "Héroe naval registrado exitosamente");
            model.addAttribute("tipoMensaje", "success");
            model.addAttribute("nuevoHeroe", new HeroeNaval());

        } catch (Exception e) {
            model.addAttribute("mensaje", "Error al registrar héroe naval");
            model.addAttribute("tipoMensaje", "error");
        }

        // Recargar lista actualizada
        List<HeroeNaval> heroes = heroeNavalRepository.findAll();
        model.addAttribute("heroes", heroes);

        return "admin/heroes-admin"; // ← Retorna directamente la vista admin
    }


    @PostMapping("/admin/eliminar/{id}")
    public String eliminarHeroe(@PathVariable Long id, Model model) {
        try {
            heroeNavalRepository.deleteById(id);
            model.addAttribute("mensaje", "Héroe naval eliminado exitosamente");
            model.addAttribute("tipoMensaje", "success");
        } catch (Exception e) {
            model.addAttribute("mensaje", "Error al eliminar héroe naval");
            model.addAttribute("tipoMensaje", "error");
        }

        return administrarHeroes(model); // ← Recarga la vista admin
    }
}