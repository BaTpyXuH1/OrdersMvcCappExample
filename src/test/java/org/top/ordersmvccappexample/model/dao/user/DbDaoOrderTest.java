package org.top.ordersmvccappexample.model.dao.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.top.ordersmvccappexample.model.dao.order.DbDaoOrder;
import org.top.ordersmvccappexample.model.entity.Order;
import org.top.ordersmvccappexample.model.entity.User;

import java.util.List;



@SpringBootTest
public class DbDaoOrderTest {
   @Autowired
    private DbDaoOrder dbDaoOrder;
   @Autowired
   private DbDaoUser dbDaoUser;
    @Test
    void listAll() {
        List<Order> orderList = dbDaoOrder.listAll();
        System.out.println(orderList);
    }
    @Test
    void getById() {
        Order order = dbDaoOrder.getById(5);
        System.out.println(order);

    }
    @Test
    void add() {
        User user = dbDaoUser.getById(2);
        Order order = dbDaoOrder.add(new Order("asd",user));
        System.out.println(order);


    }
    @Test
    void update() {
        Order order = dbDaoOrder.getById(1);
        order.setDescription("Доставка в Киров");
        Order updated = dbDaoOrder.update(order);
        System.out.println(updated);

    }
    @Test
    void delete(){
        Order deleted = dbDaoOrder.delete(1);
        System.out.println(deleted);

    }
}

