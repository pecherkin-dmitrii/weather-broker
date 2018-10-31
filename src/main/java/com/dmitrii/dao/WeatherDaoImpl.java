package com.dmitrii.dao;

import com.dmitrii.model.Weather;
import com.dmitrii.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class WeatherDaoImpl implements WeatherDao {

    @Override
    public void save(Weather weather) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.save(weather);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Weather weather) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.delete(weather);
        session.getTransaction().commit();
    }

    @Override
    public Weather findByCity(String city) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.byNaturalId(Weather.class).using("city", city).load();
    }
}
