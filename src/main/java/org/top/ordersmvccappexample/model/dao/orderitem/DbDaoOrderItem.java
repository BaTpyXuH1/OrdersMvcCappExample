package org.top.ordersmvccappexample.model.dao.orderitem;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.top.ordersmvccappexample.model.dao.item.ItemRepository;
import org.top.ordersmvccappexample.model.dao.order.OrderRepository;
import org.top.ordersmvccappexample.model.entity.Item;
import org.top.ordersmvccappexample.model.entity.Order;
import org.top.ordersmvccappexample.model.entity.OrderItem;

import java.util.List;


@Service
public class DbDaoOrderItem implements IDaoOrderItem {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public List<OrderItem> listAll() {
        return (List<OrderItem>) orderItemRepository.findAll();

    }

    @Override
    public OrderItem getById(Integer id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public OrderItem add(OrderItem orderItem) {
        Order order = orderRepository.findById(orderItem.getOrder().getId()).orElse(null);
        if (order == null)
            return null;
        Item item = itemRepository.findById(orderItem.getItem().getId()).orElse(null);
        if (item == null)
            return null;
        return orderItemRepository.save(orderItem);
    }

    @Override
    @Transactional
    public OrderItem update(OrderItem orderItem) {
        OrderItem orderItemTemp;
        orderItemTemp = orderItemRepository.findById(orderItem.getId()).orElse(null);
        if (orderItemTemp != null)
            orderItemTemp.setQuantityItem(orderItemTemp.getQuantityItem());
        return orderItemRepository.save(orderItem);
    }

    @Override
    @Transactional
    public OrderItem delete(Integer id) {
        OrderItem orderItem = orderItemRepository.findById(id).orElse(null);
        orderItemRepository.deleteById(id);
        return orderItem;
    }
}
