package org.top.ordersmvccappexample.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model, Authentication auth) {
//        System.out.println(auth.getAuthorities());
//        System.out.println(auth.getAuthorities().toString().contains("ADMIN"));
        if (auth != null)
            model.addAttribute("isAdmin", auth.getAuthorities().toString().contains("ADMIN"));
        else
            model.addAttribute("isAdmin",false);
//        model.addAttribute("isAdmin", auth.getAuthorities().toString().contains("USER"));
        return "/index";
    }
}
