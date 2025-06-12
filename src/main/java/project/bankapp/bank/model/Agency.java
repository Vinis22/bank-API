package project.bankapp.bank.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "agency", schema = "public")
@Getter
@Setter
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "cnpj", nullable = false)
    private String cnpj;
    
    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "phone", nullable = false)
    private String phone;
    
    @Column(name = "digit", nullable = false, unique = true)
    private String digit;
    
    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<Account> accounts;
} 