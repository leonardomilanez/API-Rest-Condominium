package br.unesp.rc.MSEmployeeG1.utils;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for RabbitMQ to produce Queues, Exchange and Binding
 */

@Configuration
public class RabbitMQConfig {
    public static final String QUEUE = "maintenance.request.queue";
    public static final String EXCHANGE = "maintenance.exchange";
    public static final String ROUTING_KEY = "maintenance.request";

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue maintenanceRequestQueue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public DirectExchange maintenanceExchange() {
        return new DirectExchange("maintenance.exchange");
    }

    @Bean
    public Binding maintenanceBinding(Queue maintenanceRequestQueue, DirectExchange maintenanceExchange) {
        return BindingBuilder.bind(maintenanceRequestQueue)
                .to(maintenanceExchange)
                .with("maintenance.request");
    }
}
