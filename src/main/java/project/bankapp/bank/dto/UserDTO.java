package project.bankapp.bank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class UserDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    @NotBlank
    private String phone;

    @NotNull
    private LocalDate birthday;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private String gender;

    @NotNull
    private Long agencyId;

    private String accountType;

    private FinancialInfoDTO financialInfo;
}