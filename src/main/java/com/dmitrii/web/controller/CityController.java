package com.dmitrii.web.controller;

import com.dmitrii.dao.WeatherDao;
import com.dmitrii.model.Weather;
import com.dmitrii.service.weather.WeatherRequestService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
public class CityController {

    @Resource
    private WeatherRequestService weatherRequestService;

//    @Resource
//    private WeatherDao weatherDao;

    @Resource
    private JmsTemplate jmsTemplate;

    @RequestMapping(value = "/addCity", method = RequestMethod.GET)
    public void addCity(@RequestParam("city") String city) throws IOException {
        Weather weather = weatherRequestService.getWeather(city);
        jmsTemplate.convertAndSend("java:/jms/queue/weather-topic", weather);
//        weatherDao.save(weather);
    }
}
