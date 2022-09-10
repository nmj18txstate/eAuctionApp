package com.code.nityam.product.service.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "category_name", nullable = false)
    private String categoryName;
    @Column(name = "category_description", nullable = false)
    private String categoryDescription;

}
