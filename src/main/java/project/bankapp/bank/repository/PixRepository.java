package project.bankapp.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.bankapp.bank.model.Pix;

import java.util.Optional;

@Repository
public interface PixRepository extends JpaRepository<Pix, Long> {
     Optional<Pix> findByKeyValue(String chavePix);
}
