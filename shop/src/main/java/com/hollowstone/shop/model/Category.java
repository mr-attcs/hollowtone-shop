package com.hollowstone.shop.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String name; // "Hoodies", "T-Shirts"
}
