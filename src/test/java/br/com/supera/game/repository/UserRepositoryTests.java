package br.com.supera.game.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.supera.game.model.User;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void insertUser() {
		User user = new User((long) 1, "name", "email", "phone", "password");
		userRepository.save(user);
		Integer countUser = userRepository.findAll().size();
		assertEquals(1, countUser);
	}

	@Test
	public void checkUserSavedWithEmail() {
		User user = new User((long) 1, "name", "email", "phone", "password");
		userRepository.save(user);
		Integer countUser = userRepository.findAll().size();
		assertEquals(1, countUser);
		User user1 = userRepository.findUserByNameAndEmail("name", "email");

		assertNotNull(user1);
		assertEquals(user, user1);
	}

	@Test
	public void checkUserSavedWithEmailPassingOtherEmailShouldReturnNull() {
		User user = new User((long) 1, "name", "email", "phone", "password");
		userRepository.save(user);
		Integer countUser = userRepository.findAll().size();
		assertEquals(1, countUser);
		User user1 = userRepository.findUserByNameAndEmail("name", "email1");

		assertNull(user1);
	}
}