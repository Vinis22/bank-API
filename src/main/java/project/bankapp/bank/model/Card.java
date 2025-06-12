package project.bankapp.bank.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "card", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = {"account_id", "flag"}))
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    @NotNull
    private Account account;

    @Column(length = 4)
    private String digit;

    @Column(length = 3)
    private String cvv;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @NotNull
    private CardFlag flag;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}