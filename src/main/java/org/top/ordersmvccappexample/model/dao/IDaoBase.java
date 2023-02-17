package org.top.ordersmvccappexample.model.dao;


import jakarta.transaction.Transactional;

import java.util.List;


public interface IDaoBase<E> {
    List<E> listAll();

    E getById(Integer id);

    @Transactional
    E add(E e);

    @Transactional
    E update(E e);

    @Transactional
    E delete(Integer id);



}
