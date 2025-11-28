package org.example.lab6_20224848.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @GetMapping("/home")
    public String inicio(Model model) {
        model.addAttribute("usuarios", "Lista de usuarios");
        return "home";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        Model model) {
        if (error != null) {
            model.addAttribute("error", "Credenciales incorrectas");
        }
        return "login";
    }


    @GetMapping("/layout")
    public String home(Model model) {
        model.addAttribute("title", "Inicio");
        model.addAttribute("content", "home :: content");
        model.addAttribute("active", "home");
        return "layout";
    }
}
