package com.code.nityam.product.service.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "short_description", nullable = false)
    private String shortDescription;
    @Column(name = "detail_description", nullable = false)
    private String detailDescription;
    @JoinColumn(name = "category", nullable = false)
    @OneToOne(fetch = EAGER)
    private Category category;
    @Column(name = "starting_price", nullable = false)
    private Double startingPrice;
    @Column(name = "ending_price", nullable = false)
    private Double endingPrice;
    @Column(name = "bid_end_date", nullable = false)
    private Date bidEndDate;
}
