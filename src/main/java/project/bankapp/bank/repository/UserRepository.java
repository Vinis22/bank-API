package project.bankapp.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.bankapp.bank.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCpf(String cpf);
    boolean existsByCpf(String cpf);
}