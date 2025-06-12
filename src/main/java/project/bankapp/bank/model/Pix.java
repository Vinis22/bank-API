package project.bankapp.bank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import project.bankapp.bank.enums.KeyType;

@Entity
@Getter
@Setter
public class Pix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private KeyType keyType;

    @Column(nullable = false, unique = true)
    @Size(max = 140, message = "The key value must not exceed 140 characters")
    private String keyValue;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}