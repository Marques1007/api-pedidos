package br.com.cotiinformatica.api_pedidos.services;

import br.com.cotiinformatica.api_pedidos.dtos.CriarPedidoDto;
import br.com.cotiinformatica.api_pedidos.entities.OutboxMessage;
import br.com.cotiinformatica.api_pedidos.entities.Pedido;
import br.com.cotiinformatica.api_pedidos.repositories.OutboxMessageRepository;
import br.com.cotiinformatica.api_pedidos.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private OutboxMessageRepository outboxMessageRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional(rollbackOn = Exception.class)
    public String criarPedido(CriarPedidoDto dto) throws Exception {

        //Preenchendo os dados do Pedido
        var pedido = new Pedido();
        pedido.setDataHora(LocalDateTime.now());
        pedido.setCliente(dto.cliente());
        pedido.setValor(BigDecimal.valueOf(dto.valor()));
        pedido.setDescricao(dto.descricao());
        pedido.setTipoPagamento(dto.tipoPagamento());

        //Salvando o pedido no banco de dados
        pedidoRepository.save(pedido);

        //Preenchendo os dados da OutboxMessage
        var outboxMessage = new OutboxMessage();
        outboxMessage.setPedido(pedido); //Relacionamento com Pedido
        outboxMessage.setDataHoraCriacao(LocalDateTime.now());
        outboxMessage.setTransmitido(false);
        outboxMessage.setTitulo("PEDIDO_CRIADO");
        outboxMessage.setConteudo(objectMapper.writeValueAsString(pedido));

        //Salvando o registro na OutboxMessage
        outboxMessageRepository.save(outboxMessage);

        return "Pedido criado com sucesso!";
    }

    public List<Pedido> consultarPorIntervalo(LocalDateTime inicio, LocalDateTime fim) {
        return pedidoRepository.findAllByDataHoraBetween(inicio, fim);
    }
}
