package com.dmitrii.dao;

import com.dmitrii.model.Weather;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
public class WeatherDaoTest {
    private String city = "TestCity";
    private Double temperature = 99.0;
    private String description = "TestDescription";

    @Resource
    private WeatherDao weatherDao;

    @Test
    public void saveAndLoadTest() {
        Weather weather = new Weather();
        weather.setCity(city);
        weather.setTemperature(temperature);
        weather.setDescription(description);
        weatherDao.save(weather);

        Weather responseWeather = weatherDao.findByCity(city);
        Assert.assertEquals(city, responseWeather.getCity());
        Assert.assertEquals(temperature, responseWeather.getTemperature());
        Assert.assertEquals(description, responseWeather.getDescription());
    }
}
