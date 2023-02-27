package org.top.ordersmvccappexample.model.dao.item;


import jakarta.transaction.Transactional;
import org.top.ordersmvccappexample.model.entity.Item;

import java.util.List;

public interface IDaoItem  {

    List<Item> listAll();

    Item getById(Integer id);

    @Transactional
    Item add(Item e);

    @Transactional
    Item update(Item e);

    @Transactional
    Item delete(Integer id);
}
