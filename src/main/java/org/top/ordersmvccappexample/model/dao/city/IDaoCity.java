package org.top.ordersmvccappexample.model.dao.city;

import jakarta.transaction.Transactional;
import org.top.ordersmvccappexample.model.entity.City;

import java.util.List;

public interface IDaoCity {

    List<City> listAll();

    City getById(Integer id);

    @Transactional
    City add(City city);

    @Transactional
    City update(City city);

    @Transactional
    City delete(Integer id);
}
