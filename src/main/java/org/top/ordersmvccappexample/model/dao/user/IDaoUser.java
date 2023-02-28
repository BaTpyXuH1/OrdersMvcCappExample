package org.top.ordersmvccappexample.model.dao.user;


import org.top.ordersmvccappexample.model.entity.User;

// DAO-интерфейс пользователя
public interface IDaoUser {
    User getUserByLogin(String login);
    User addUser(User user);
}
