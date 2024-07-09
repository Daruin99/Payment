package com.payment_service.payment_service.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;

    @OneToOne
    @JoinColumn(name = "card_number", referencedColumnName = "card_number")
    private Card card;

    private BigDecimal balance;
}