package org.top.ordersmvccappexample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.ordersmvccappexample.model.dao.client.IDaoClient;
import org.top.ordersmvccappexample.model.entity.Client;
import org.top.ordersmvccappexample.model.entity.Item;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IDaoClient daoClient;

    @GetMapping("/")
    public String listALl(Model model) {
        List<Client> clients = daoClient.listAll();
        model.addAttribute("clients",clients);
        return "/client/client-list";
    }

    @GetMapping("/add/")
    public String getAddForm(Model model){
        Client client = new Client();
        Item item = new Item();
        model.addAttribute("client",client);
        model.addAttribute("item",item);
        return "/client/client-form";

    }
    @PostMapping("/add/")
    public String addNewClient(Client client, RedirectAttributes ra){
        Client addedClient = daoClient.add(client);
        ra.addFlashAttribute("goodMsg","Клиент " + addedClient + " добавлен");
        return "redirect:/client/";

    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Integer clientId){
        daoClient.delete(clientId);
        return "redirect:/client/";
    }
    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") Integer clientId, Model model){
        Client client = daoClient.getById(clientId);
        model.addAttribute("client",client);
        return "/client/client-update";

    }
    @PostMapping("/update/")
    public String updateClient(Client client){
        daoClient.update(client);
        return "redirect:/client/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer clientId,Model model){
        Client client = daoClient.getById(clientId);
        model.addAttribute("client",client);
        return "/client/client-detail";
    }
}
