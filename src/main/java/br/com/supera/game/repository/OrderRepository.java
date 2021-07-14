package br.com.supera.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.supera.game.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,  Long> {

}
