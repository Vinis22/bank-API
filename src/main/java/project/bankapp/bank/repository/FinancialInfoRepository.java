package project.bankapp.bank.repository;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.bankapp.bank.model.FinancialInfo;

@Repository
public interface FinancialInfoRepository extends JpaRepository<FinancialInfo, Long> {

}
