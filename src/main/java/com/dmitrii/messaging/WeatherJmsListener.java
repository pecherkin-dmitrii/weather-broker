package com.dmitrii.messaging;

import com.dmitrii.dao.WeatherDao;
import com.dmitrii.model.Weather;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class WeatherJmsListener {

    @Resource
    private WeatherDao weatherDao;

    @JmsListener(destination = "java:/jms/topic/weather-topic")
    public void receiveWeather(Weather weather) {
        weatherDao.save(weather);
    }

}
