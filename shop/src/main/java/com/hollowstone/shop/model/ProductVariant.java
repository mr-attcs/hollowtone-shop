package com.hollowstone.shop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="product_variants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false, fetch=FetchType.LAZY)
    private Product product;

    @Column(nullable=false)
    private String sku;

    private String size; // "S","M","L" / "34","35"...
    private String color;

    @Column(nullable=false)
    private Integer priceCents; // EUR in Cents

    @OneToOne(mappedBy="variant", cascade=CascadeType.ALL, orphanRemoval=true)
    private Inventory inventory;
}
