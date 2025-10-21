package com.hollowstone.shop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Order order;
    @ManyToOne(optional = false)
    private ProductVariant variant;
    @Column(nullable = false)
    private Integer unitPriceCents;
    @Column(nullable = false)
    private Integer quantity;
}
