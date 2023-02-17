package org.top.ordersmvccappexample.model.dao.client;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.top.ordersmvccappexample.model.entity.Client;

import java.util.List;


@Service
public class DbDaoClient implements IDaoClient {
    @Autowired
    private ClientRepository clientRepository;


    @Override
    public List<Client> listAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    @Transactional
    public Client getById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Client add(Client client) {        //добавить клиента
        return clientRepository.save(client);

    }

    @Override
    @Transactional
    public Client update(Client client) { // обновить сведения о клиенте
        Client clientTemp = clientRepository.findById(client.getId()).orElse(null); // клиент найден
        if (clientTemp != null)
            clientTemp.setClientName(client.getClientName());
        return clientTemp;
    }


    @Override
    @Transactional
    public Client delete(Integer id) {         // удалить клиента
        Client client = clientRepository.findById(id).orElse(null);
        if (client != null)
            clientRepository.deleteById(id);
        return client;
    }
}
