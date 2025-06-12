package project.bankapp.bank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "financial_info", schema = "public")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class FinancialInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    @JsonBackReference
    private User user;

    @Column(name = "monthly_income", nullable = false, precision = 15, scale = 2)
    private BigDecimal monthlyIncome;

    @Column(name = "assets", nullable = false, precision = 15, scale = 2)
    private BigDecimal assets = BigDecimal.ZERO;

    @Column(name = "dependents")
    private Integer dependents;

    @Column(name = "credit_margin", precision = 19, scale = 2)
    private BigDecimal creditMargin;

    @Column(name = "credit_limit", precision = 15, scale = 2, insertable = false, updatable = false)
    private BigDecimal creditLimit;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();


    public void calculateCreditMargin() {
        BigDecimal income = monthlyIncome != null ? monthlyIncome : BigDecimal.ZERO;
        int deps = dependents != null ? dependents : 0;
        this.creditMargin = income.multiply(BigDecimal.valueOf(0.3))
                .subtract(BigDecimal.valueOf(deps * 100));
    }
}