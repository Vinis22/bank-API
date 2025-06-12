package project.bankapp.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.bankapp.bank.dto.TransactionDTO;
import project.bankapp.bank.service.AccountService;
import project.bankapp.bank.service.PixService;
import project.bankapp.bank.service.TransactionService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/transaction")
public class TransactionController {

    private final PixService pixService;
    private final AccountService accountService;
    private final TransactionService transactionService;

    @PostMapping("/pix")
    public ResponseEntity<Void> performPix(@RequestBody TransactionDTO dto) {
        transactionService.performPix(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/ted")
    public ResponseEntity<Void> performTed(@RequestBody TransactionDTO dto) {
        transactionService.performTed(dto);
        return ResponseEntity.ok().build();
    }
}