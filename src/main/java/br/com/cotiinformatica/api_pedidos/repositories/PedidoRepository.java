package br.com.cotiinformatica.api_pedidos.repositories;

import br.com.cotiinformatica.api_pedidos.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	// Consulta pedidos por intervalo de dataHora (inclusivo)
	List<Pedido> findAllByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);

}
