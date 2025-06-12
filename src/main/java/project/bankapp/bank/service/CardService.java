package project.bankapp.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.bankapp.bank.model.Account;
import project.bankapp.bank.model.Card;
import project.bankapp.bank.repository.CardRepository;
import project.bankapp.bank.model.Agency;
import project.bankapp.bank.model.CardFlag;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public Card createCardForAccount(Account account, Agency agency) {
        Card card = new Card();
        card.setAccount(account);
        card.setDigit(agency.getDigit());
        card.setCvv(generateCvv());
        card.setFlag(generateRandomFlag());
        card.setExpirationDate(LocalDate.now().plusYears(4));
        card.setActive(true);
        card.setCreatedAt(LocalDateTime.now());

        return cardRepository.save(card);
    }

    private String generateCvv() {
        Random random = new Random();
        return String.format("%03d", random.nextInt(1000));
    }

    private CardFlag generateRandomFlag() {
        CardFlag[] flags = {CardFlag.VISA, CardFlag.MASTERCARD, CardFlag.ELO, CardFlag.AMEX};
        return flags[new Random().nextInt(flags.length)];
    }
}