package org.top.ordersmvccappexample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.ordersmvccappexample.model.dao.item.IDaoItem;
import org.top.ordersmvccappexample.model.dao.order.IDaoOrder;
import org.top.ordersmvccappexample.model.entity.Item;
import org.top.ordersmvccappexample.model.entity.Order;

import java.util.List;

@Controller
@RequestMapping("/item")

public class ItemController {
    @Autowired
    private IDaoItem daoItem;

    @Autowired
    private IDaoOrder daoOrder;

    @GetMapping("/")
    public String listAll(Model model) {
        List<Item> items = daoItem.listAll();
        // Добавляем контекст
        model.addAttribute("items", items);
        return "/item/item-list";
    }

    @GetMapping("/add/")
    public String getAddItemForm(Model model) {
        Item item = new Item();
        List<Order> orders = daoOrder.listAll();
        model.addAttribute("item", item);
        model.addAttribute("orders", orders);
        return "/item/item-form";
    }

    @PostMapping("/add/")
    public String saveItem(Item item, RedirectAttributes ra) {
        Item addedItem = daoItem.add(item);
        ra.addFlashAttribute("goodMsg", "Товар " + addedItem + " добавлен");
        return "redirect:/item/";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") Integer itemId) {
        daoItem.delete(itemId);
        return "redirect:/item/";
    }

    @GetMapping("/update/{id}")
    public String getUpdateItem(@PathVariable("id") Integer itemId, Model model) {
        Item item = daoItem.getById(itemId);
        model.addAttribute("item", item);
        return "/item/item-update";
    }

    @PostMapping("/update/")
    public String updateItem(Item item) {
        daoItem.update(item);
        return "redirect:/item/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer itemId, Model model) {
        Item item = daoItem.getById(itemId);
        model.addAttribute("item", item);
        return "/item/item-detail";
    }

}
