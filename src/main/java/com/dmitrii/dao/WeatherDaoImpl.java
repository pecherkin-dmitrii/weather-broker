package com.dmitrii.dao;

import com.dmitrii.model.Weather;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Repository
@Transactional
public class WeatherDaoImpl implements WeatherDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void save(Weather weather) {
        sessionFactory.getCurrentSession().saveOrUpdate(weather);
    }

    @Override
    public void delete(Weather weather) {
        sessionFactory.getCurrentSession().delete(weather);
    }

    @Override
    public Weather findByCity(String city) {
        Session session = sessionFactory.openSession();
        return session.byNaturalId(Weather.class).using("city", city).load();
    }
}
