package br.com.supera.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.supera.game.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,  Long> {

  public User findUserByNameAndEmail(String name, String email);

}
