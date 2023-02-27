package org.top.ordersmvccappexample.model.dao.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.top.ordersmvccappexample.model.entity.Client;
import java.util.List;


@SpringBootTest
public class DbDaoClientTest {

    @Autowired
    private DbDaoClient dbDaoClient;

    @Test
    void listAll() {
        List<Client> clientList = dbDaoClient.listAll();
        System.out.println(clientList);


    }

        @Test
    void getById() {
       Client client = dbDaoClient.getById(4);
       System.out.println(client);


       }
    @Test
    void add() {
        Client client = dbDaoClient.add(new Client("Piter"));
        System.out.println(client);


    }

    @Test
    void update() {
        Client client = dbDaoClient.getById(3);
        client.setClientName("Jack");
        Client updated = dbDaoClient.update(client);
        System.out.println(updated);

    }

    @Test
    void delete() {
        Client deleted = dbDaoClient.delete(1);
        System.out.println(deleted);

    }
}
