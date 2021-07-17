package br.com.supera.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.supera.game.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,  Long> {
	 public Product findProductByNameAndPrice(String name, double price);
}
