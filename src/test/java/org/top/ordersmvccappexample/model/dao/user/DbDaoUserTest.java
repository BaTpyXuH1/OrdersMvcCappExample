package org.top.ordersmvccappexample.model.dao.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.top.ordersmvccappexample.model.entity.User;


@SpringBootTest
class DbDaoUserTest {

    @Autowired
    private IDaoUser daoUser;

    @Test
    void addUser() {
        User user = new User("user", "qwerty");
        daoUser.addUser(user);
    }

}