package org.top.ordersmvccappexample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.ordersmvccappexample.model.dao.basket.IDaoBasket;
import org.top.ordersmvccappexample.model.dao.orderitem.IDaoOrderItem;
import org.top.ordersmvccappexample.model.entity.Basket;
import org.top.ordersmvccappexample.model.entity.OrderItem;

import java.util.List;

@Controller
@RequestMapping("/basket")
public class BasketController {
    @Autowired
    private IDaoBasket daoBasket;
    @Autowired
    private IDaoOrderItem daoOrderItem;


    @GetMapping("/")
    public String listAll(Model model){
        List<Basket> baskets = daoBasket.listAll();
        model.addAttribute("basket",baskets);
        return "/basket/basket-list";
    }
    @GetMapping("/add/")
    public String getBasketForm(Model model) {
        Basket basket = new Basket();
        List<OrderItem> orderItems = daoOrderItem.listAll();
        model.addAttribute("basket",basket);
        model.addAttribute("orderItem", orderItems);
        return "/basket/basket-form";
    }
    @PostMapping("/add/")
    public String saveBasket(Basket basket, RedirectAttributes ra) {
        Basket addBasket = daoBasket.add(basket);
        ra.addFlashAttribute("goodMsg", "Заказ " + addBasket + " добавлен");
        return "redirect:/basket/";
    }
    @GetMapping("/delete/{id}")
    public String deleteBasket(@PathVariable("id") Integer basketId) {
        daoBasket.delete(basketId);
        return "redirect:/basket/";
    }
    @GetMapping("/update/{id}")
    public String getUpdateBasket(@PathVariable("id") Integer basketId, Model model) {
        Basket basket = daoBasket.getById(basketId);
        model.addAttribute("basket",basket);
        return "/basket/basket-update";
    }

    @PostMapping("/update/")
    public String updateBasket(Basket basket) {
        daoBasket.update(basket);
        return "redirect:/basket/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer basketId, Model model) {
        Basket basket = daoBasket.getById(basketId);
        model.addAttribute("basket",basket);
        return "/basket/basket-detail";
    }

}
