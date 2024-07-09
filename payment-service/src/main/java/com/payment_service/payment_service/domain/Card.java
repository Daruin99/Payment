package com.payment_service.payment_service.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Card {
    @Id
    @Column(name = "card_number", nullable = false, length = 16)
    private String cardNumber;

    // N.b to be handled in the e-commerce, the user should enter this format MM/YY
    @Column(name = "expiry_date", nullable = false)
    private String expiryDate;

    @Column(name = "cvv", nullable = false, length = 3)
    private String cvv;


}