package project.bankapp.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.bankapp.bank.dto.TransactionDTO;
import project.bankapp.bank.model.Transaction;
import project.bankapp.bank.repository.TransactionRepository;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Transactional
    public Transaction performPix(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setFromAccount(transactionDTO.getFromAccount());
        transaction.setToAccount(transactionDTO.getToAccount());
        transaction.setAmount(transactionDTO.getAmount());
        return transactionRepository.save(transaction);
    }

    @Transactional
    public Transaction performTed(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setFromAccount(transactionDTO.getFromAccount());
        transaction.setToAccount(transactionDTO.getToAccount());
        transaction.setAmount(transactionDTO.getAmount());
        return transactionRepository.save(transaction);
    }
}