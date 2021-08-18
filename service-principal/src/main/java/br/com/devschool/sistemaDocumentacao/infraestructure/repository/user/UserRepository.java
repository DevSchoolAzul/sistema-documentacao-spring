package br.com.devschool.sistemaDocumentacao.infraestructure.repository.user;

import br.com.devschool.sistemaDocumentacao.domain.external.client.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String username);
}
