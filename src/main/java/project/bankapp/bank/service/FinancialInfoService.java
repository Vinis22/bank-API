package project.bankapp.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.bankapp.bank.dto.FinancialInfoDTO;
import project.bankapp.bank.model.FinancialInfo;
import project.bankapp.bank.model.User;
import project.bankapp.bank.repository.FinancialInfoRepository;
import project.bankapp.bank.repository.UserRepository;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class FinancialInfoService {

    private final FinancialInfoRepository financialInfoRepository;
    private final UserRepository userRepository;

    @Transactional
    public void updateFinancialInfo(Long userId, FinancialInfoDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        FinancialInfo info = user.getFinancialInfo();
        if (info == null) {
            info = new FinancialInfo();
            info.setUser(user);
        }

        info.setMonthlyIncome(dto.getMonthlyIncome() != null ? dto.getMonthlyIncome() : BigDecimal.ZERO);
        info.setAssets(dto.getAssets() != null ? dto.getAssets() : BigDecimal.ZERO);
        info.setDependents(dto.getDependents());

        info.calculateCreditMargin();

        financialInfoRepository.save(info);
    }
}