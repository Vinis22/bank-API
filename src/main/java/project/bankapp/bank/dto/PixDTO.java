package project.bankapp.bank.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import project.bankapp.bank.enums.KeyType;

@Getter
@Setter
public class PixDTO {

    @NotNull(message = "Key type is required")
    private KeyType keyType;

    private String keyValue;

    private Long accountId;
}