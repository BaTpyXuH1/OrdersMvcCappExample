package org.top.ordersmvccappexample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.ordersmvccappexample.model.dao.item.IDaoItem;
import org.top.ordersmvccappexample.model.dao.item.ItemRepository;
import org.top.ordersmvccappexample.model.dao.order.IDaoOrder;
import org.top.ordersmvccappexample.model.entity.Item;
import org.top.ordersmvccappexample.model.entity.Order;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/item")

public class ItemController {
    @Autowired
    private IDaoItem daoItem;

    @Autowired
    private IDaoOrder daoOrder;


    @GetMapping("/")
    public String listAll(Model model, Authentication auth) {
        List<Item> items = daoItem.listAll();
        if (auth != null)
            model.addAttribute("isAdmin", auth.getAuthorities().toString().contains("ADMIN"));
        else
            model.addAttribute("isAdmin",false);
        model.addAttribute("items",daoItem.listAll());
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
    public String saveItem(Item item, @RequestParam("previewImageData") MultipartFile imageData,
                           RedirectAttributes ra) throws IOException {
        String imageDataAsString = Base64
                .getEncoder()
                .encodeToString(imageData.getBytes());
        item.setPreviewImage(imageDataAsString);
        Item addedItem = daoItem.add(item);   // save(item)
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
