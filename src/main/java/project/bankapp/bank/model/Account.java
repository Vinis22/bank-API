package project.bankapp.bank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account", schema = "public")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", nullable = false, unique = true)
    @NotNull(message = "Account number cannot be null")
    private String accountNumber;

    @Column(nullable = false)
    @NotNull(message = "Balance cannot be null")
    private BigDecimal balance;

    @Column(nullable = false)
    @NotNull(message = "Account type cannot be null")
    private String type;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Card> cards = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "agency_id", nullable = false)
    private Agency agency;

    private LocalDateTime createdAt;

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}