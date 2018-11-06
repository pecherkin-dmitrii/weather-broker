package com.dmitrii.dao;

import com.dmitrii.model.Weather;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Repository
public class WeatherDaoImpl implements WeatherDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Weather weather) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.saveOrUpdate(weather);
        session.getTransaction().commit();
    }

    @Override
    @Transactional
    public void delete(Weather weather) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.delete(weather);
        session.getTransaction().commit();
    }

    @Override
    public Weather findByCity(String city) {
        Session session = sessionFactory.openSession();
        return session.byNaturalId(Weather.class).using("city", city).load();
    }
}
