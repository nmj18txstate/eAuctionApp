package com.code.nityam.bid.service.repo;

import com.code.nityam.bid.service.domain.Bid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BidRepo extends JpaRepository<Bid,Long> {
    @Override
    Optional<Bid> findById(Long id);
    Optional<Page<Bid>> findAllByStartingPrice(Double price,Pageable pageable);
    Optional<Page<Bid>> findAllByWinningPrice(Double price,Pageable pageable);
    Optional<Page<Bid>> findByDescriptionContainsIgnoreCase(String term,Pageable pageable);
    Optional<Page<Bid>> findByWinner(Long winner,Pageable pageable);

}
