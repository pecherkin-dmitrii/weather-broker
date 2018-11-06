package com.dmitrii.service.weather;

import com.dmitrii.model.Weather;
import com.dmitrii.service.ServiceTest;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class WeatherServiceIT extends ServiceTest {
    private String checkCity = "Saratov";

    @Test
    public void getWeatherTest() throws IOException {
        Weather weather = weatherRequestService.getWeather(checkCity);

        Assert.assertEquals(checkCity, weather.getCity());
    }
}
