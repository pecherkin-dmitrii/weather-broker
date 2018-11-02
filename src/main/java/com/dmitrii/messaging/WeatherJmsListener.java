package com.dmitrii.messaging;

import com.dmitrii.dao.WeatherDao;
import com.dmitrii.model.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MessageConverter;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

class WeatherJmsListener implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherJmsListener.class);

    @Resource
    private MessageConverter messageConverter;

    @Resource
    private WeatherDao weatherDao;

    @Override
    public void onMessage(Message message) {
        try {
            Weather weather = (Weather) messageConverter.fromMessage(message);
            weatherDao.save(weather);
        } catch (JMSException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
