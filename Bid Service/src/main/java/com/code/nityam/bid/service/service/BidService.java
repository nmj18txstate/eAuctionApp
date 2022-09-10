package com.code.nityam.bid.service.service;

import com.code.nityam.bid.service.domain.Bid;
import com.code.nityam.bid.service.domain.BidTemplate;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BidService {
    Optional<Bid> saveBid(Bid bid);
    Optional<Page<Bid>> findBidByStartingPrice(Double price,int pageNumber);
    Optional<Page<Bid>> findBidByWinningPrice(Double price,int pageNumber);
    Optional<Page<Bid>> findBidByDescription(String term,int pageNumber);
    Optional<Page<Bid>> findBidByWinner(Long winner,int pageNumber);
    Optional<Bid> updateBid(Bid bid);
    void deleteId(Long id);
    void delete(Bid bid);

    BidTemplate getBidWithWinner(Long bidId, Long winnerId);

}
