package com.dmitrii.service;

import com.dmitrii.service.weather.WeatherRequestServiceImpl;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
public abstract class ServiceTest {
    @Mock
    protected RestTemplate restTemplateMock;

    @Resource
    @InjectMocks
    protected WeatherRequestServiceImpl weatherRequestService;

    protected void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
    }
}
