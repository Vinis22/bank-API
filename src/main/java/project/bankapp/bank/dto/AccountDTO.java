package project.bankapp.bank.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class AccountDTO {
    private Long id;
    private String accountNumber;
    private String type;
    private BigDecimal balance;
    private Long userId;
    private Long agencyId;
} 