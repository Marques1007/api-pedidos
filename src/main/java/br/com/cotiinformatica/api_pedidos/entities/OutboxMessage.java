package br.com.cotiinformatica.api_pedidos.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "outbox_message")
@Data
public class OutboxMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @Column(name = "data_hora_criacao", nullable = false)
    private LocalDateTime dataHoraCriacao;

    @Column(name = "data_hora_transmissao")
    private LocalDateTime dataHoraTransmissao;

    @Column(name = "transmitido", nullable = false)
    private Boolean transmitido;

    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "conteudo", nullable = false, length = 500)
    private String conteudo;
}
