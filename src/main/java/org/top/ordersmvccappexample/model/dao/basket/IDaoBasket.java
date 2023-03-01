package org.top.ordersmvccappexample.model.dao.basket;

import jakarta.transaction.Transactional;
import org.top.ordersmvccappexample.model.entity.Basket;


import java.util.List;

public interface IDaoBasket {
    List<Basket> listAll();

    Basket getById(Integer id);

    @Transactional
    Basket add(Basket basket);

    @Transactional
    Basket update(Basket basket);

    @Transactional
    Basket delete(Integer id);
}
