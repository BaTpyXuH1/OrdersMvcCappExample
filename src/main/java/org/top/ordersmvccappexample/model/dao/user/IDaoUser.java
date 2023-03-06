package org.top.ordersmvccappexample.model.dao.user;


import jakarta.transaction.Transactional;
import org.top.ordersmvccappexample.model.entity.User;

import java.util.List;

// DAO-интерфейс пользователя
public interface IDaoUser {
    List<User> listAll();

    User getById(Integer id);

    @Transactional
    User add(User user);

    @Transactional
    User update(User user);

    @Transactional
    User delete(Integer id);
    User getUserByLogin(String login);
    User addUser(User user);

}
