package project.bankapp.bank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgencyDTO {
    private Long id;
    private String name;
    private String cnpj;
    private String address;
    private String phone;
    private String digit;
} 