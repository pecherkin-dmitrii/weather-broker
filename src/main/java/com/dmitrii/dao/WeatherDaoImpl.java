package com.dmitrii.dao;

import com.dmitrii.model.Weather;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Repository
public class WeatherDaoImpl implements WeatherDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Weather weather) {
        sessionFactory.getCurrentSession().saveOrUpdate(weather);
    }

    @Override
    @Transactional
    public void delete(Weather weather) {
        sessionFactory.getCurrentSession().delete(weather);
    }

    @Override
    @Transactional(readOnly = true)
    public Weather findByCity(String city) {
        Session session = sessionFactory.openSession();
        return session.byNaturalId(Weather.class).using("city", city).load();
    }
}
