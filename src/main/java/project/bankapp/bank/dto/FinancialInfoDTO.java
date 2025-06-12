package project.bankapp.bank.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FinancialInfoDTO {

    private BigDecimal monthlyIncome;

    private BigDecimal assets;

    private Integer dependents;
}