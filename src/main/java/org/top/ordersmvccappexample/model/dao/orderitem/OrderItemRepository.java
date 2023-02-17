package org.top.ordersmvccappexample.model.dao.orderitem;

import org.springframework.data.repository.CrudRepository;
import org.top.ordersmvccappexample.model.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem,Integer> {
}
