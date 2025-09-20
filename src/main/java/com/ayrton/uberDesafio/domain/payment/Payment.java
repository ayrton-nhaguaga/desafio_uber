package com.ayrton.uberDesafio.domain.payment;

import com.ayrton.uberDesafio.domain.ride.Ride;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    private String id;

    private Ride ride;

    private PaymentStatus paymentStatus;

    private LocalDateTime paidAt;
    private double amount;

    public enum PaymentStatus{
        PAID, UNPAID, FAILED
    }
}
