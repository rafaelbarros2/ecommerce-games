package br.com.supera.game.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;


public class EntityTest {

    @Test
    public void UserTest() {
        User user = new User((long) 1,"name", "email", "phone","password");
        assertEquals("name", user.getName());
        assertTrue(user.getName().contains("name"));
    }
}