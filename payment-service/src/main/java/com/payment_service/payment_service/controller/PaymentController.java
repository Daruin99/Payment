package com.payment_service.payment_service.controller;
import com.payment_service.payment_service.domain.Account;
import com.payment_service.payment_service.dto.PaymentRequestDTO;
import com.payment_service.payment_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    private AccountService accountService;

    @Autowired
    public PaymentController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        Account account = accountService.findByCardNumber(paymentRequestDTO.getCardNumber());
        if (account != null && accountService.isSufficientBalance(account, paymentRequestDTO.getAmount())) {
            accountService.updateBalance(account, paymentRequestDTO.getAmount());
            return ResponseEntity.ok("Payment Successful");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient Balance");
    }

}
