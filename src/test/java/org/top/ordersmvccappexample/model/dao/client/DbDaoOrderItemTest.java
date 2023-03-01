package org.top.ordersmvccappexample.model.dao.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.top.ordersmvccappexample.model.dao.basket.DbDaoBasket;
import org.top.ordersmvccappexample.model.dao.item.DbDaoItem;
import org.top.ordersmvccappexample.model.dao.order.DbDaoOrder;
import org.top.ordersmvccappexample.model.dao.orderitem.DbDaoOrderItem;
import org.top.ordersmvccappexample.model.entity.*;

import java.util.List;

@SpringBootTest
public class DbDaoOrderItemTest {

    @Autowired
    private DbDaoOrderItem dbDaoOrderItem;

    @Autowired
    private DbDaoOrder dbDaoOrder;

    @Autowired
    private DbDaoItem dbDaoItem;
    @Autowired
    private DbDaoBasket dbDaoBasket;

    @Test
    void listAll() {
        List<OrderItem> orderItemList = dbDaoOrderItem.listAll();
        System.out.println(orderItemList);
    }

    @Test
    void getById() {
        OrderItem orderItem = dbDaoOrderItem.getById(4);
        System.out.println(orderItem);
    }

    @Test
    void add() {

        Item item = dbDaoItem.getById(9);
        Order order = dbDaoOrder.getById(8);
        OrderItem orderItem = dbDaoOrderItem.add(new OrderItem(200, item, order));
        System.out.println(orderItem);


    }

    @Test
    void update() {
        OrderItem orderItem = dbDaoOrderItem.getById(1);
        orderItem.setQuantityItem(150);
        OrderItem updated = dbDaoOrderItem.update(orderItem);
        System.out.println(updated);


    }

    @Test
    void delete() {
        OrderItem deleted = dbDaoOrderItem.delete(3);
        System.out.println(deleted);

    }
}
