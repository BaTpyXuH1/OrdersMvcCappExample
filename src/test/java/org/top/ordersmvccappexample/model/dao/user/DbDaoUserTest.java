package org.top.ordersmvccappexample.model.dao.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.top.ordersmvccappexample.model.dao.user.DbDaoUser;
import org.top.ordersmvccappexample.model.entity.User;

import java.util.List;


@SpringBootTest
public class DbDaoUserTest {

    @Autowired
    private DbDaoUser dbDaoUser;

    @Test
    void listAll() {
        List<User> userList = dbDaoUser.listAll();
        System.out.println(userList);


    }

        @Test
    void getById() {
       User user = dbDaoUser.getById(4);
       System.out.println(user);


       }
    @Test
    void add() {
        User user = dbDaoUser.add(new User("Piter"));
        System.out.println(user);


    }

    @Test
    void update() {
        User user = dbDaoUser.getById(3);
        user.setUserName("Jack");
        User updated = dbDaoUser.update(user);
        System.out.println(updated);

    }

    @Test
    void delete() {
        User deleted = dbDaoUser.delete(1);
        System.out.println(deleted);

    }
    @Test
    void addUser() {
        User user = new User("admin", "qwerty");
        dbDaoUser.addUser(user);
    }
}
