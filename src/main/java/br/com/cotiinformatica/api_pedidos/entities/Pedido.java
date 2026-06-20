package br.com.cotiinformatica.api_pedidos.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "cliente", nullable = false, length = 100)
    private String cliente;

    @Column(name = "descricao", nullable = false, length = 250)
    private String descricao;

    @Column(name = "tipo_pagamento", nullable = false, length = 50)
    private String tipoPagamento;
}
