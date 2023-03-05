package org.top.ordersmvccappexample.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model, Authentication auth) {
        if (auth != null)
            model.addAttribute("isAdmin", auth.getAuthorities().toString().contains("ADMIN"));
        else
            model.addAttribute("isAdmin",false);
        return "/index";
    }
}
