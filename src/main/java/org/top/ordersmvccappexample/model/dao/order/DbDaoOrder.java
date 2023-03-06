package org.top.ordersmvccappexample.model.dao.order;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.top.ordersmvccappexample.model.dao.user.UserRepository;
import org.top.ordersmvccappexample.model.entity.Order;
import org.top.ordersmvccappexample.model.entity.User;

import java.util.List;



@Service
public class DbDaoOrder implements IDaoOrder {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Order> listAll() {
        return (List<Order>) orderRepository.findAll();

    }

    @Override
    @Transactional
    public Order getById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }


    @Override
    @Transactional
    public Order add(Order order) {
        User user = userRepository.findById(order.getUser().getId()).orElse(null);
        if (user == null)
            return null;
        user.orderSet.add(order);
        return orderRepository.save(order);
    }


    @Override
    @Transactional
    public Order update(Order order) {
        Order orderTemp = orderRepository.findById(order.getId()).orElse(null);
        if (orderTemp != null)
            orderTemp.setDescription(order.getDescription());
        return orderTemp;

    }

    @Override
    @Transactional
    public Order delete(Integer id) {
        Order order = orderRepository.findById(id).orElse(null);
        orderRepository.deleteById(id);
        return order;
    }
}
