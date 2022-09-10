package com.code.nityam.bid.service.service;

import com.code.nityam.bid.service.domain.Bid;
import com.code.nityam.bid.service.domain.BidTemplate;
import com.code.nityam.bid.service.domain.Buyer;
import com.code.nityam.bid.service.repo.BidRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BidServiceImpl implements BidService{
    private final BidRepo bidRepo;
    private final RestTemplate restTemplate;
    @Override
    public Optional<Bid> saveBid(Bid bid) {
        return Optional.of(bidRepo.save(bid));
    }

    @Override
    public Optional<Page<Bid>> findBidByStartingPrice(Double price, int pageNumber) {
        return bidRepo.findAllByStartingPrice(price,PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Page<Bid>> findBidByWinningPrice(Double price, int pageNumber) {
        return bidRepo.findAllByWinningPrice(price,PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Page<Bid>> findBidByDescription(String term, int pageNumber) {
        return bidRepo.findByDescriptionContainsIgnoreCase(term,PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Page<Bid>> findBidByWinner(Long winner, int pageNumber) {
        return bidRepo.findByWinner(winner,PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Bid> updateBid(Bid bid) {
        Optional<Bid> b = bidRepo.findById(bid.getId());
        if (b.isPresent()){
            b.get().setStartingPrice(bid.getStartingPrice());
            b.get().setWinningPrice(bid.getWinningPrice());
            b.get().setDescription(bid.getDescription());
            b.get().setWinner(bid.getWinner());
        }
        return Optional.empty();
    }

    @Override
    public void deleteId(Long id) {
        bidRepo.deleteById(id);
    }

    @Override
    public void delete(Bid bid) {
        bidRepo.delete(bid);
    }

    @Override
    public BidTemplate getBidWithWinner(Long bidId, Long winnerId) {
        BidTemplate bidTemplate = new BidTemplate();
        Optional<Bid> bid = bidRepo.findById(bidId);
        Buyer buyer = restTemplate.getForObject("http://CUSTOMER-SERVICE/api/v1/buyer/id/"+winnerId,Buyer.class);
        bidTemplate.setBid(bid.get());
        bidTemplate.setBuyer(buyer);
        return bidTemplate;
    }
}
