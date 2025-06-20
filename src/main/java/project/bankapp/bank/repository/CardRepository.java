package project.bankapp.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.bankapp.bank.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
