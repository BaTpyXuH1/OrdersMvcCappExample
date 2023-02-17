package org.top.ordersmvccappexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.ordersmvccappexample.model.dao.item.DbDaoItem;
import org.top.ordersmvccappexample.model.dao.order.DbDaoOrder;
import org.top.ordersmvccappexample.model.dao.orderitem.DbDaoOrderItem;
import org.top.ordersmvccappexample.model.entity.Item;
import org.top.ordersmvccappexample.model.entity.Order;
import org.top.ordersmvccappexample.model.entity.OrderItem;

import java.util.List;

@Controller
@RequestMapping("/orderItem")
public class OrderItemController {
    @Autowired
    private DbDaoOrderItem daoOrderItem;

    @Autowired
    private DbDaoOrder daoOrder;

    @Autowired
    private DbDaoItem daoItem;


    @GetMapping("/")
    public String listAll(Model model){
        List<OrderItem> orderItems = daoOrderItem.listAll();
        model.addAttribute("orderItems", orderItems);
        return "/orderItem/orderItem-list";
    }

    // Получение form добавления нового заказа
    @GetMapping("/add/")
    public String getOrderItemForm(Model model){
        OrderItem orderItem = new OrderItem();
        // Добавим варианты выбора
        List<Order> orders = daoOrder.listAll();
        List<Item> items = daoItem.listAll();
        model.addAttribute("orderItem",orderItem);
        model.addAttribute("orders",orders);
        model.addAttribute("items",items);
        return "/orderItem/orderItem-form";
    }

    @PostMapping("/add/")
    public String saveOrderItem(OrderItem orderItem, RedirectAttributes ra){
        // Сохранить в БД
        OrderItem addOrderItem = daoOrderItem.add(orderItem);
//      ra.addFlashAttribute("goodMsg","Order " + addOrderItem + "added");
        // Перенаправляемся на список
        return "redirect:/orderItem/";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrderItem(@PathVariable("id") Integer orderItemId){
        daoOrderItem.delete(orderItemId);
        return "redirect:/orderItem/";
    }
    @GetMapping("/update/{id}")
    public String getUpdateOrderItem(@PathVariable("id") Integer orderItemId,Model model){
        // Получить заказ для обновления
        OrderItem orderItem = daoOrderItem.getById(orderItemId);
        model.addAttribute("orderItem",orderItem);
        return "/orderItem/orderItem-update";
    }

    @PostMapping("/update/")
    public String updateOrderItem(OrderItem orderItem){
        // Сохранить
        daoOrderItem.update(orderItem);
        // Вернуться в список сущностей
        return "redirect:/orderItem/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer orderItemId,Model model){
        OrderItem orderItem = daoOrderItem.getById(orderItemId);
        model.addAttribute("orderItem",orderItem);
        return "/orderItem/orderItem-detail";
    }



}
