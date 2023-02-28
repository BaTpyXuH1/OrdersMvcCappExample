package org.top.ordersmvccappexample.model.dao.user;


import org.springframework.data.repository.CrudRepository;
import org.top.ordersmvccappexample.model.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByLogin(String login);
}
