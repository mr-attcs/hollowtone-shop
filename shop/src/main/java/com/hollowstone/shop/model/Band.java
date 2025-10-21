package com.hollowstone.shop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bands")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String slug; // z.B. "ashes-of-echo"

    @Column(nullable = false)
    private String name;

    private String contactEmail;
    private String spotifyUrl;
    private String instagram;
    private String website;

    @Embedded
    private PayoutSettings payout;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PayoutSettings {
        private String provider; // "stripe" | "paypal"
        private String accountId; // Stripe Connect id oder PayPal merchant id
    }
}
