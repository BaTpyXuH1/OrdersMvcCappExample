package org.top.ordersmvccappexample.model.dao.client;

import org.springframework.data.repository.CrudRepository;
import org.top.ordersmvccappexample.model.entity.Client;



public interface ClientRepository extends CrudRepository<Client,Integer> {


}
