package com.hollowstone.shop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false) private User user;

    @Enumerated(EnumType.STRING) @Column(nullable=false)
    private Status status; // CREATED, PAID, FULFILLING, SHIPPED, COMPLETED, CANCELED

    @Column(nullable=false) private Integer totalCents;
    @Column(nullable=false) private String currency; // "EUR"

    // Band-spezifisch? Für gemischte Warenkörbe könnten mehrere Bands drin sein;
    // in V1 lassen wir nur EINE Band pro Bestellung zu (vereinfacht, payouts easy).
    @ManyToOne(optional=false) private Band band;

    private String buyerEmail; // redundanter Snapshot
    private String buyerName;

    public enum Status { CREATED, PAID, FULFILLING, SHIPPED, COMPLETED, CANCELED }
}

