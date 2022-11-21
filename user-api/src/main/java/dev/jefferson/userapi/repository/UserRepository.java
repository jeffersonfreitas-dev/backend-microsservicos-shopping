package dev.jefferson.userapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jefferson.userapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByCpf(final String cpf);
	
	List<User> queryByNomeLike(final String name);

}
