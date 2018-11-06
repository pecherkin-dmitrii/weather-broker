package com.dmitrii.service.weather;

import com.dmitrii.model.Weather;
import com.dmitrii.service.ServiceTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class WeatherRequestServiceTest extends ServiceTest {
    private String testJson;

    @Before
    public void setUp() throws IOException {
        super.setUp();

        Path path = Paths.get("src/test/resources/testJson.txt");
        testJson = new String(Files.readAllBytes(path));
    }

    @Test
    public void getWeatherTest() throws IOException {
        when(restTemplateMock.getForObject(anyString(), any())).thenReturn(testJson);

        Weather testWeather = weatherRequestService.getWeather("any");
        Assert.assertEquals("TestCity", testWeather.getCity());
        Assert.assertEquals(new Double(99.0), testWeather.getTemperature());
        Assert.assertEquals("TestDescription", testWeather.getDescription());
    }
}
