package org.top.ordersmvccappexample;

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
        model.addAttribute("client",client);
        return "client/client-form";

    }
    @PostMapping("/add/")
    public String addNewClient(Client client, RedirectAttributes ra){
        //Сохранить в БД нового клиента
        Client addedClient = daoClient.add(client);
        //Отправим сообщение о том что клиент добавлен
//        ra.addFlashAttribute("goodMsg","Client " + addedClient + "added");
        //Пренаправить ответ на вывод всех клиентов
        return "redirect:/client/";

    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Integer clientId){
        daoClient.delete(clientId);
        return "redirect:/client/";
    }
    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") Integer clientId, Model model){
        // Получить клиента для обновления
        Client client = daoClient.getById(clientId);
        // Добавить этого клиента в контекст
        model.addAttribute("client",client);
        // Вернуть форму Обновления
        return "/client/client-update";

    }
    @PostMapping("/update/")
    public String updateClient(Client client){
        // Сохранить клиента
        daoClient.update(client);
        //Вернуться на список сущностей
        return "redirect:/client/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer clientId,Model model){
        Client client = daoClient.getById(clientId);
        model.addAttribute("client",client);
        return "/client/client-detail";
    }

}
