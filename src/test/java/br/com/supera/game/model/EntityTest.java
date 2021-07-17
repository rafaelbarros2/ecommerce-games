package br.com.supera.game.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class EntityTest {

	@Test
	public void UserTest() {
		User user = new User( (long) 1, "name", "email", "phone", "password");
		assertEquals("name", user.getName());
		assertTrue(user.getName().contains("name"));
	}
	
	@Test
	public void ProductTest() {
		Product product = new Product(1, "name", (double) 30,(double) 320, "img");
		assertEquals("name", product.getName());
		assertTrue(product.getName().contains("name"));
	}
}