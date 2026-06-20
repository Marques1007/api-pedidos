package br.com.cotiinformatica.api_pedidos.controllers;

import br.com.cotiinformatica.api_pedidos.dtos.CriarPedidoDto;
import br.com.cotiinformatica.api_pedidos.entities.Pedido;
import br.com.cotiinformatica.api_pedidos.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidosController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("criar")
    public ResponseEntity<String> criar(@RequestBody CriarPedidoDto dto) {
        try {
            var response = pedidoService.criarPedido(dto);

            //HTTP 201 (CREATED)
            return ResponseEntity.status(201).body(response);
        }
        catch(Exception e) {
            //HTTP 500 (INTERNAL SERVER ERROR)
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("consultar-por-intervalo")
    public ResponseEntity<?> consultarPorIntervalo(
            @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {
        try {
            List<Pedido> pedidos = pedidoService.consultarPorIntervalo(dataInicio, dataFim);
            return ResponseEntity.ok(pedidos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
