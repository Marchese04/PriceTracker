package com.Marchese.PriceTracker.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//this part call to the system "the database will manage the id"
    private Long id;

    @Column(nullable = false)// "nullable" it's to don't accept null
    private String name;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String store;

    @Column(name = "target_price", nullable = false)
    private BigDecimal targetPrice;// BigDecimal is better to work with monetary values because is more accurate

    @Column(name = "created_at")
    private OffsetDateTime createdAt;//I chose OffsetDataTime because it takes into account the local time zone

    @PrePersist//this annotation call "execute this method automatically right before this object is saved in the bank for the first time"
    protected  void onCreate(){
        this.createdAt = OffsetDateTime.now();
    }

}
