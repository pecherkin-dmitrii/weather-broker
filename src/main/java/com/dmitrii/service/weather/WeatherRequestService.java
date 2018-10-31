package com.dmitrii.service.weather;

import com.dmitrii.model.Weather;

import java.io.IOException;

public interface WeatherRequestService {
    Weather getWeather(String city) throws IOException;
}
