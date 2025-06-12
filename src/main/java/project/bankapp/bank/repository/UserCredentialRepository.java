package project.bankapp.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.bankapp.bank.model.User;
import project.bankapp.bank.model.UserCredential;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {
    Optional<UserCredential> findByUser(User user);
}