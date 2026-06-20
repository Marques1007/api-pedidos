package br.com.cotiinformatica.api_pedidos.dtos;

public record CriarPedidoDto (
    String cliente,
    Double valor,
    String descricao,
    String tipoPagamento
) {

}