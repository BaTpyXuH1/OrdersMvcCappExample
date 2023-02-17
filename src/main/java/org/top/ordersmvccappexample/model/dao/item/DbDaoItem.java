package org.top.ordersmvccappexample.model.dao.item;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.top.ordersmvccappexample.model.entity.Item;

import java.util.List;


@Service
public class DbDaoItem implements IDaoItem {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> listAll() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public Item getById(Integer id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Item add(Item item) {
        return itemRepository.save(item);
    }


    @Override
    @Transactional
    public Item update(Item item) {
        Item itemTemp = itemRepository.findById(item.getId()).orElse(null);
        if (itemTemp != null)
            itemTemp.setItemName(item.getItemName());
        return itemTemp;
    }


    @Override
    @Transactional
    public Item delete(Integer id) {
        Item item = itemRepository.findById(id).orElse(null);
        itemRepository.deleteById(id);
        return item;
    }
}
