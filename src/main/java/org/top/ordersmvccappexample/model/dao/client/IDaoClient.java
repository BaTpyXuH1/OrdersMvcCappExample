package org.top.ordersmvccappexample.model.dao.client;

import jakarta.transaction.Transactional;
import org.top.ordersmvccappexample.model.entity.Client;


import java.util.List;


public interface IDaoClient   {
    List<Client> listAll();

    Client getById(Integer id);

    @Transactional
    Client add(Client client);

    @Transactional
    Client update(Client client);

    @Transactional
    Client delete(Integer id);

}
