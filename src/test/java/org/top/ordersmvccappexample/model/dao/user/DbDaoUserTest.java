package org.top.ordersmvccappexample.model.dao.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.top.ordersmvccappexample.model.dao.client.IDaoClient;
import org.top.ordersmvccappexample.model.entity.Client;
import org.top.ordersmvccappexample.model.entity.User;


@SpringBootTest
class DbDaoUserTest {

    @Autowired
    private IDaoUser daoUser;
    @Autowired
    private IDaoClient daoClient;

    @Test
    void addUser() {
        User user = new User("user", "qwerty");
        daoUser.addUser(user);
    }

}