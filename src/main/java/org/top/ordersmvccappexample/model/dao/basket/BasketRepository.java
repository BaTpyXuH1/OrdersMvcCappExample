package org.top.ordersmvccappexample.model.dao.basket;

import org.springframework.data.repository.CrudRepository;
import org.top.ordersmvccappexample.model.entity.Basket;

public interface BasketRepository extends CrudRepository<Basket,Integer> {
}
