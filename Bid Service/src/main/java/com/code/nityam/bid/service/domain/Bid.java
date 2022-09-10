package com.code.nityam.bid.service.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Getter @Setter @ToString @RequiredArgsConstructor @Entity(name = "bid")
public class Bid {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "starting_price",nullable = false)
    private Double startingPrice;
    @Column(name = "winning_price",nullable = false)
    private Double winningPrice;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "winner",nullable = false)
    private Long winner;
}
