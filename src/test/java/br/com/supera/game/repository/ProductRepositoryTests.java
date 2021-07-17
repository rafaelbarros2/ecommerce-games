package br.com.supera.game.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.supera.game.model.Product;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProductRepositoryTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void insertProduct() {
		Product product = new Product(1, "name", (double) 30, (double) 320, "img");
		productRepository.save(product);
		Integer countProduct = productRepository.findAll().size();
		assertEquals(1, countProduct);
	}

	@Test
	public void checkProductSavedWithPrice() {
		Product product = new Product(1, "name", (double) 30, (double) 320, "img");
		productRepository.save(product);
		Integer countProduct = productRepository.findAll().size();
		assertEquals(1, countProduct);
		Product product1 = productRepository.findProductByNameAndPrice("name", (double) 30);

		assertNotNull(product1);
		assertEquals(product, product1);
	}

}