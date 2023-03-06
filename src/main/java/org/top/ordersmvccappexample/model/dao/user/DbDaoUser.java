package org.top.ordersmvccappexample.model.dao.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.top.ordersmvccappexample.model.entity.User;

import java.util.List;


// имплементация для работы с БД
@Service
public class DbDaoUser implements IDaoUser {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(User user) {
        User userUp = userRepository.findById(user.getId()).orElse(null);
        if (userUp != null)
            userUp.setUserName(user.getUserName());
        return userUp;
    }

    @Override
    @Transactional
    public User delete(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null)
            userRepository.deleteById(id);
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User addUser(User user) {
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }
}
