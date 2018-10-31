package com.dmitrii.dao;

import com.dmitrii.model.Weather;

public interface WeatherDao {

    void save(Weather weather);
    void delete(Weather weather);
    Weather findByCity(String city);
}
