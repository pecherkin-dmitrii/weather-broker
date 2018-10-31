package com.dmitrii.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jndi.JndiTemplate;

import javax.jms.ConnectionFactory;
import javax.naming.NamingException;

@Configuration
@EnableJms
public class MessagingConfig {

    @Bean
    public ConnectionFactory connectionFactory() throws NamingException {
        return (ConnectionFactory) new JndiTemplate().lookup("java:/ConnectionFactory");
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() throws NamingException {
        DefaultJmsListenerContainerFactory factory =
            new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrency("3-10");
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate() throws NamingException {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        return jmsTemplate;
    }
}
