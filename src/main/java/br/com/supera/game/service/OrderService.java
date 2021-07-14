package br.com.supera.game.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supera.game.model.Order;
import br.com.supera.game.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById( Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
