package org.top.ordersmvccappexample.model.dao.basket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.top.ordersmvccappexample.model.entity.Basket;

import java.util.List;

@Service
public class DbDaoBasket implements IDaoBasket {
    @Autowired
    private BasketRepository basketRepository;

    @Override
    public List<Basket> listAll() {
        return (List<Basket>) basketRepository.findAll();
    }

    @Override
    public Basket getById(Integer id) {
        return basketRepository.findById(id).orElse(null);
    }

    @Override
    public Basket add(Basket basket) {
        return basketRepository.save(basket);
    }

    @Override
    public Basket update(Basket basket) {
        Basket basketTemp = basketRepository.findById(basket.getId()).orElse(null);
        if (basketTemp != null)
            basketTemp.setOrderItemBasket(basket.getOrderItemBasket());
        return null;
    }

    @Override
    public Basket delete(Integer id) {
        Basket basket = basketRepository.findById(id).orElse(null);
        if (basket != null)
            basketRepository.deleteById(id);
        return basket;
    }
}
