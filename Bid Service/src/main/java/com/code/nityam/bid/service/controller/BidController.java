package com.code.nityam.bid.service.controller;

import com.code.nityam.bid.service.domain.Bid;
import com.code.nityam.bid.service.service.BidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = "/api/v1/bid")
@RequiredArgsConstructor
public class BidController {
    private final BidService bidService;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> saveBid(@RequestBody Bid bid) {
        return ResponseEntity.status(CREATED).body(bidService.saveBid(bid));
    }

    @GetMapping(value = "/starting/{price}/{page_number}", produces = "application/json")
    public ResponseEntity<?> findUsingStarting(@PathVariable(value = "price") String price, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(bidService.findBidByStartingPrice(Double.parseDouble(price), Integer.parseInt(pageNumber) - 1));
    }

    @GetMapping(value = "/winning/{price}/{page_number}", produces = "application/json")
    public ResponseEntity<?> findUsingWinning(@PathVariable(value = "price") String price, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(bidService.findBidByWinningPrice(Double.parseDouble(price), Integer.parseInt(pageNumber) - 1));
    }

    @GetMapping(value = "/description/{desc}/{page_number}", produces = "application/json")
    public ResponseEntity<?> findUsingDescription(@PathVariable(value = "desc") String desc, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(bidService.findBidByDescription(desc, Integer.parseInt(pageNumber) - 1));
    }
    @GetMapping(value = "/with_winner/{bid_id}/{bid_winner}",produces = "application/json")
    public ResponseEntity<?> getBidWithWinner(@PathVariable(value = "bid_id") String bidId, @PathVariable(value = "bid_winner") String bidWinner){
        return ResponseEntity.status(OK).body(bidService.getBidWithWinner(Long.parseLong(bidId),Long.parseLong(bidWinner)));
    }

    @GetMapping(value = "/winner/{winner}/{page_number}", produces = "application/json")
    public ResponseEntity<?> findUsingWinner(@PathVariable(value = "winner") String price, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(bidService.findBidByWinner(Long.parseLong(price), Integer.parseInt(pageNumber) - 1));
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateBid(@RequestBody Bid bid) {
        return ResponseEntity.status(ACCEPTED).body(bidService.updateBid(bid));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteUsingId(@PathVariable(value = "id") String id) {
        bidService.deleteId(Long.parseLong(id));
        return ResponseEntity.status(OK).body("Deleted successfully...");
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete(Bid bid) {
        bidService.delete(bid);
        return ResponseEntity.status(OK).body("Deleted successfully...");
    }

}
