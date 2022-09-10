package com.code.nityam.bid.service.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class BidTemplate {
    private Bid bid;
    private Buyer buyer;
}
