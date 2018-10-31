package com.dmitrii.web.controller;

import com.dmitrii.dao.WeatherDao;
import com.dmitrii.model.Weather;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class WeatherController {

    @Resource
    private WeatherDao weatherDao;

    @RequestMapping(value = "/getWeatherByCity", method = RequestMethod.GET)
    @ResponseBody
    public Weather getWeatherByCity(@RequestParam("city") String city) {
        return weatherDao.findByCity(city);
    }
}
