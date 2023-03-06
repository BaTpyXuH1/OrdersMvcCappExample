package org.top.ordersmvccappexample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.ordersmvccappexample.model.dao.user.IDaoUser;
import org.top.ordersmvccappexample.model.entity.Item;
import org.top.ordersmvccappexample.model.entity.User;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IDaoUser daoUser;

    @GetMapping("/")
    public String listALl(Model model, Authentication auth) {
        List<User> users = daoUser.listAll();
        if (auth != null)
            model.addAttribute("isAdmin", auth.getAuthorities().toString().contains("ADMIN"));
        else
            model.addAttribute("isAdmin",false);
        model.addAttribute("users",users);
        return "/user/user-list";
    }
    @GetMapping("/add/")
    public String getAddForm(Model model){
        User user = new User();
        Item item = new Item();
        model.addAttribute("user",user);
        model.addAttribute("item",item);
        return "/user/user-form";
    }
    @PostMapping("/add/")
    public String addNewUser(User user, RedirectAttributes ra){
        User addUser = daoUser.add(user);
        ra.addFlashAttribute("goodMsg","Клиент " + addUser + " добавлен");
        return "redirect:/user/";
    }
    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") Integer userId, Model model){
        User user = daoUser.getById(userId);
        model.addAttribute("user",user);
        return "/user/user-update";
    }
    @PostMapping("/update/")
    public String updateUser(User user){
        daoUser.update(user);
        return "redirect:/user/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer userId,Model model){
        User user = daoUser.getById(userId);
        model.addAttribute("user",user);
        return "/user/user-detail";
    }
}
