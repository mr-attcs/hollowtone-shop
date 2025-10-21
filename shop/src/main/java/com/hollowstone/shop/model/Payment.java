package com.hollowstone.shop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Provider provider; // STRIPE, PAYPAL

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status; // INITIATED, SUCCEEDED, FAILED

    private String providerPaymentId; // e.g. Stripe session id / PayPal capture id
    private String providerPayoutAccount; // band payout account snapshot
    private String rawWebhookPayload; // optional audit

    public enum Provider {STRIPE, PAYPAL}

    public enum Status {INITIATED, SUCCEEDED, FAILED}
}
