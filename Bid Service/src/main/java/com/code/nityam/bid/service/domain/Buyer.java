package com.code.nityam.bid.service.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Buyer {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String pin;
    private String phone;
    private String email;
}
