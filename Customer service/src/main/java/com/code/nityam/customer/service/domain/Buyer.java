package com.code.nityam.customer.service.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;
@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id",nullable = false,length = 255)
    private Long id;
    @Column(name = "first_name",nullable = false,length = 255)
    private String firstName;
    @Column(name = "last_name",nullable = false,length = 255)
    private String lastName;
    @Column(name = "address",nullable = false,length = 255)
    private String address;
    @Column(name = "city",nullable = false,length = 255)
    private String city;
    @Column(name = "state",nullable = false,length = 255)
    private String state;
    @Column(name = "pin",nullable = false,length = 255)
    private String pin;
    @Column(name = "phone",nullable = false,length = 255)
    private String phone;
    @Column(name = "email",nullable = false,length = 25)
    private String email;
}
