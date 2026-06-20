package br.com.cotiinformatica.api_pedidos.repositories;

import br.com.cotiinformatica.api_pedidos.entities.OutboxMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutboxMessageRepository extends JpaRepository<OutboxMessage, Integer> {

    /*
        Consulta para retornar as mensagens não transmitidas
        em ordem crescente de data de criação
        e ainda com paginação
     */
    @Query("""
        SELECT outbox FROM OutboxMessage outbox
        WHERE outbox.transmitido = false
        ORDER BY outbox.dataHoraCriacao ASC
    """)
    List<OutboxMessage> find(Pageable pageable);
}
