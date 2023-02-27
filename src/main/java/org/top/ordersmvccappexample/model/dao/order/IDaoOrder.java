package org.top.ordersmvccappexample.model.dao.order;


import jakarta.transaction.Transactional;
import org.top.ordersmvccappexample.model.entity.Order;

import java.util.List;

public interface IDaoOrder  {

    List<Order> listAll();

    Order getById(Integer id);

    @Transactional
    Order add(Order order);

    @Transactional
    Order update(Order order);

    @Transactional
    Order delete(Integer id);
}
