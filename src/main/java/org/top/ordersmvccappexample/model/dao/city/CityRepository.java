package org.top.ordersmvccappexample.model.dao.city;

import org.springframework.data.repository.CrudRepository;
import org.top.ordersmvccappexample.model.entity.City;

public interface CityRepository extends CrudRepository<City,Integer> {
}
