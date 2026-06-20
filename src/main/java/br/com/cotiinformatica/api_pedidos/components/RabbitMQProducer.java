package br.com.cotiinformatica.api_pedidos.components;

import br.com.cotiinformatica.api_pedidos.repositories.OutboxMessageRepository;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RabbitMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private OutboxMessageRepository outboxMessageRepository;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 60000) //1 minuto
    public void publish() {

        //Ler os primeiros 10 registros não transmitidos obtidos da OutboxMessage
        var pageable = PageRequest.of(0,10);

        //Ler as mensagens
        var mensagens = outboxMessageRepository.find(pageable);

        //Percorrer cada registro obtido
        try {
            for(var item : mensagens) {

                //Enviando para a mensageria
                rabbitTemplate.convertAndSend(queue.getName(), item.getConteudo());

                //Atualizando o banco de dados
                item.setTransmitido(true);
                item.setDataHoraTransmissao(LocalDateTime.now());

                //Atualizando a outboxmessage
                outboxMessageRepository.save(item);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
