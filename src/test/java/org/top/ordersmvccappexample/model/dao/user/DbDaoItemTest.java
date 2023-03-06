package org.top.ordersmvccappexample.model.dao.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.top.ordersmvccappexample.model.dao.item.DbDaoItem;
import org.top.ordersmvccappexample.model.entity.Item;
import java.util.List;

@SpringBootTest
public class DbDaoItemTest {

    @Autowired
    private DbDaoItem dbDaoItem;

    @Test
    void listAll() {
        List<Item> itemList = dbDaoItem.listAll();
        System.out.println(itemList);
    }

    @Test
    void getById() {
        Item item = dbDaoItem.getById(4);
        System.out.println(item);
    }

    @Test
    void add() {
        Item itemAdd = dbDaoItem.add(new Item("GameBoy", 1243));
        System.out.println(itemAdd);
    }

    @Test
    void update() {
        Item item = dbDaoItem.getById(3);
        item.setItemName("Sony");
        Item updated = dbDaoItem.update(item);
        System.out.println(updated);


    }

    @Test
    void delete() {
        Item deletedItem = dbDaoItem.delete(2);
        System.out.println(deletedItem);

    }
}


