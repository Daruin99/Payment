package com.payment_service.payment_service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequestDTO {
    private BigDecimal amount;
    private String cardNumber;
}
