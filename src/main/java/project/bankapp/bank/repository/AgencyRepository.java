package project.bankapp.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.bankapp.bank.model.Agency;

public interface AgencyRepository extends JpaRepository<Agency, Long> {
} 