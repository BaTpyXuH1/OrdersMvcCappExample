package org.top.ordersmvccappexample.model.dao.item;

import org.springframework.data.repository.CrudRepository;
import org.top.ordersmvccappexample.model.entity.Item;

public interface ItemRepository extends CrudRepository<Item,Integer> {
}
