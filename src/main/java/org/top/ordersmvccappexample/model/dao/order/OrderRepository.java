package org.top.ordersmvccappexample.model.dao.order;

import org.springframework.data.repository.CrudRepository;
import org.top.ordersmvccappexample.model.entity.Order;

public interface OrderRepository extends CrudRepository<Order,Integer> {
}
