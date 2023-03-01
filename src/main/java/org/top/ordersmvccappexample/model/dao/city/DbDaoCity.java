package org.top.ordersmvccappexample.model.dao.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.top.ordersmvccappexample.model.entity.City;


import java.util.List;
@Service
public class DbDaoCity implements IDaoCity{
    @Autowired
    private CityRepository cityRepository;
    @Override
    public List<City> listAll() {
        return (List<City>) cityRepository.findAll();
    }

    @Override
    public City getById(Integer id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public City add(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City update(City city) {
        City cityTemp = cityRepository.findById(city.getId()).orElse(null);
        if (cityTemp != null)
            cityTemp.setCityTitle(city.getCityTitle());
        return null;
    }

    @Override
    public City delete(Integer id) {
        City city = cityRepository.findById(id).orElse(null);
        cityRepository.deleteById(id);
        return city;
    }
}
