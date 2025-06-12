package project.bankapp.bank.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.bankapp.bank.model.Account;
import project.bankapp.bank.service.AccountService;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public Account createAccount(
            @RequestParam String type,
            @RequestParam Long userId,
            @RequestParam Long agencyId
    ) {
        return accountService.createAccount(type, userId, agencyId);
    }

    @PostMapping("/deposit")
    public void deposit(
            @RequestParam String accountNumber,
            @RequestParam BigDecimal amount
    ) throws AccountNotFoundException {
        accountService.deposit(accountNumber, amount);
    }

    @PostMapping("/withdraw")
    public void withdraw(
            @RequestParam String accountNumber,
            @RequestParam BigDecimal amount
    ) throws AccountNotFoundException {
        accountService.withdraw(accountNumber, amount);
    }

    @PostMapping("/transfer")
    public void transfer(
            @RequestParam String fromAccountNumber,
            @RequestParam String toAccountNumber,
            @RequestParam BigDecimal amount
    ) throws AccountNotFoundException {
        accountService.transfer(fromAccountNumber, toAccountNumber, amount);
    }
}