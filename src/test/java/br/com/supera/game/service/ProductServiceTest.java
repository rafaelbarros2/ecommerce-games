package br.com.supera.game.service;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import antlr.collections.Stack;
import br.com.supera.game.controller.UserController;
import br.com.supera.game.model.Product;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class ProductServiceTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@Test
	public void callingWithoutParameterShouldReturnBadRequest() throws Exception {
		List<Stack> result = new ArrayList<>();
		result.add((Stack) new Product(1, "name", (double) 30, (double) 320, "img"));
		Mockito.when(productService.findById((long) 5)).thenReturn((Product) result);
		this.mockMvc.perform(get("/product")).andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void shouldReturnJustOneFromResult() throws Exception {
		List<Store> result = new ArrayList<>();
		result.add((Store) new Product(1, "name", (double) 30, (double) 320, "img"));
		Mockito.when(productService.findById((long) 1)).thenReturn((Product) result);
		this.mockMvc.perform(get("/product").queryParam("1")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().string(containsString("name")));
	}

}
