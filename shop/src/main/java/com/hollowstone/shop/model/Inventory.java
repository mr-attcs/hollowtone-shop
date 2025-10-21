package com.hollowstone.shop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional=false)
    @JoinColumn(name="variant_id")
    private ProductVariant variant;

    @Column(nullable=false)
    private Integer stock; // verfügbare Stücke
}

