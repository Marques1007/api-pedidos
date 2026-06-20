package br.com.cotiinformatica.api_pedidos.configurations;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    /*
        Nome da fila do RabbitMQ
     */
    @Value("${spring.rabbitmq.queue}")
    private String queue;

    /*
        Configurando a conexão com a fila no RabbitMQ
     */
    @Bean
    Queue getQueue() {
        return new Queue(queue, true);
    }
}
