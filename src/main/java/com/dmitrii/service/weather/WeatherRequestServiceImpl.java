package com.dmitrii.service.weather;

import com.dmitrii.model.Weather;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class WeatherRequestServiceImpl implements WeatherRequestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherRequestServiceImpl.class);

    @Value("${weather.request.url}")
    private String blankUrl;

    public Weather getWeather(String city) throws IOException {
        LOGGER.info("Getting weather info for city {}.", city);
        
        String url = String.format(blankUrl, city);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        JsonNode jsonNode = new ObjectMapper().readTree(response);
        Weather weather = new Weather();
        weather.setCity(jsonNode.get("query").get("results").get("channel")
            .get("location").get("city").textValue());
        weather.setTemperature(jsonNode.get("query").get("results").get("channel")
            .get("item").get("condition").get("temp").asDouble());
        weather.setDescription(jsonNode.get("query").get("results").get("channel")
            .get("item").get("condition").get("text").textValue());
        return weather;
    }
}