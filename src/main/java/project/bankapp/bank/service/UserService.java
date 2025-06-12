package project.bankapp.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.bankapp.bank.dto.FinancialInfoDTO;
import project.bankapp.bank.dto.UserDTO;
import project.bankapp.bank.model.*;
import project.bankapp.bank.repository.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final FinancialInfoService financialInfoService;
    private final UserCredentialRepository userCredentialRepository;
    private final PasswordEncoder passwordEncoder;
    private final AgencyService agencyService;

    @Transactional
    public User createUserWithAgency(UserDTO userDTO, Long agencyId) {
        Agency agency = agencyService.getAgencyById(agencyId)
            .orElseThrow(() -> new IllegalArgumentException("Agency not found for ID: " + agencyId));
        validateUniqueFields(userDTO);

        User user = new User();
        user.setName(userDTO.getName());
        user.setCpf(userDTO.getCpf());
        user.setBirthday(userDTO.getBirthday());
        user.setGender(userDTO.getGender());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());

        Account account = new Account();
        account.setUser(user);
        account.setAgency(agency);
        account.setAccountNumber(generateAccountNumber());
        account.setType(userDTO.getAccountType());
        account.setBalance(BigDecimal.ZERO);

        userRepository.save(user);

        UserCredential credentials = new UserCredential();
        credentials.setUsername(userDTO.getCpf());
        credentials.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        credentials.setUser(user);
        userCredentialRepository.save(credentials);

        if (userDTO.getFinancialInfo() != null) {
            setUserFinancialInfo(user, userDTO.getFinancialInfo());
        }

        return user;
    }

    public User findUserByCpf(String cpf) {
        return userRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("User with CPF " + cpf + " not found"));
    }

    @Transactional
    public void updateFinancialInfo(Long userId, FinancialInfoDTO dto) {
        financialInfoService.updateFinancialInfo(userId, dto);
    }

    private void setUserFinancialInfo(User user, FinancialInfoDTO dto) {
        FinancialInfo financialInfo = new FinancialInfo();

        financialInfo.setMonthlyIncome(dto.getMonthlyIncome() != null ? dto.getMonthlyIncome() : BigDecimal.ZERO);
        financialInfo.setAssets(dto.getAssets() != null ? dto.getAssets() : BigDecimal.ZERO);
        financialInfo.setDependents(dto.getDependents());
        financialInfo.setUser(user);

        financialInfo.calculateCreditMargin();

        user.setFinancialInfo(financialInfo);

        userRepository.save(user);
    }

    private void validateUniqueFields(UserDTO userDTO) {
        if (userRepository.existsByCpf(userDTO.getCpf())) {
            throw new RuntimeException("A user with the provided CPF already exists: " + userDTO.getCpf());
        }
    }

    private String generateAccountNumber() {
        long timestamp = System.currentTimeMillis();
        return "ACC-" + timestamp;
    }
}