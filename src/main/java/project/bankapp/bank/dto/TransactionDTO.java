package project.bankapp.bank.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionDTO {
    private String keyPix;
    private BigDecimal amount;
    private Long accountOriginId;
    private String fromAccount;
    private String toAccount;

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }
}
