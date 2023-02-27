package org.top.ordersmvccappexample.model.dao.orderitem;


import jakarta.transaction.Transactional;
import org.top.ordersmvccappexample.model.entity.OrderItem;

import java.util.List;

public interface IDaoOrderItem   {

    List<OrderItem> listAll();

    OrderItem getById(Integer id);

    @Transactional
    OrderItem add(OrderItem orderItem);

    @Transactional
    OrderItem update(OrderItem orderItem);

    @Transactional
    OrderItem delete(Integer id);
}
