package org.top.ordersmvccappexample.model.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.top.ordersmvccappexample.model.dao.client.ClientRepository;
import org.top.ordersmvccappexample.model.entity.Client;
import org.top.ordersmvccappexample.model.entity.User;


// имплементация для работы с БД
@Service
public class DbDaoUser implements IDaoUser {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User addUser(User user) {
        // перед добавлением пользователя захешируем его пароль
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        User addUser = userRepository.save(user);
        Client addClient = clientRepository.save(new Client(addUser));
        addUser.setClient(addClient);
        return userRepository.save(user);
    }
}
