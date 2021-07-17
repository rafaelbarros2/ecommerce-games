package br.com.supera.game.controller;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import br.com.supera.game.model.Product;
import br.com.supera.game.repository.ProductRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository produdctRepository;

    @Test	
    public void findAllUsers() throws Exception {
    	Product product = new Product(1, "name", (double) 30,(double) 320, "img");
        
        List<Product> productList = List.of(product);
        when(produdctRepository.findAll()).thenReturn(productList);
        this.mockMvc.perform(get("/product"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("name")));
    }

}