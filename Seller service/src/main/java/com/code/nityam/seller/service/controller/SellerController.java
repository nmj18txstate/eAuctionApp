package com.code.jamie.seller.service.controller;

import com.code.jamie.seller.service.domain.Seller;
import com.code.jamie.seller.service.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = "/api/v1/seller")
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody Seller seller) {
        return ResponseEntity.status(CREATED).body(sellerService.saveSeller(seller));
    }

    @GetMapping(value = "/first_name/{first_name}/{page_number}", produces = "application/json")
    public ResponseEntity<?> findUsingFirstname(@PathVariable(value = "first_name") String firstName, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(sellerService.findFirstName(firstName, Integer.parseInt(pageNumber) - 1));
    }

    @GetMapping(value = "/first_name/{last_name}/{page_number}", produces = "application/json")
    public ResponseEntity<?> findUsingLastname(@PathVariable(value = "last_name") String lastName, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(sellerService.findLastName(lastName, Integer.parseInt(pageNumber) - 1));
    }

    @GetMapping(value = "/address/{address}", produces = "application/json")
    public ResponseEntity<?> findUsingAddress(@PathVariable(value = "address") String address) {
        return ResponseEntity.status(OK).body(sellerService.findAddress(address));
    }

    @GetMapping(value = "/city/{city}/{page_number}", produces = "application/json")
    public ResponseEntity<?> findUsingCity(@PathVariable(value = "city") String city, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(sellerService.findCity(city, Integer.parseInt(pageNumber) - 1));
    }

    @GetMapping(value = "/state/{state}/{page_number}", produces = "application/json")
    public ResponseEntity<?> findUsingState(@PathVariable(value = "state") String state, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(sellerService.findState(state, Integer.parseInt(pageNumber) - 1));
    }

    @GetMapping(value = "/pin/{pin}", produces = "application/json")
    public ResponseEntity<?> findUsingPin(@PathVariable(value = "pin") String pin, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(sellerService.findPin(pin));
    }

    @GetMapping(value = "/phone/{phone}", produces = "application/json")
    public ResponseEntity<?> findUsingPhone(@PathVariable(value = "phone") String phone, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(sellerService.findPin(phone));
    }

    @GetMapping(value = "/email/{email}", produces = "application/json")
    public ResponseEntity<?> findUsingEmail(@PathVariable(value = "email") String email, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(sellerService.findPin(email));
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateSeller(@RequestBody Seller seller) {
        return ResponseEntity.status(ACCEPTED).body(sellerService.update(seller));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteUsingId(@PathVariable(value = "id") String id) {
        sellerService.deleteId(Long.parseLong(id));
        return ResponseEntity.status(OK).body("Deleted successfully....");
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete(Seller seller) {
        sellerService.delete(seller);
        return ResponseEntity.status(OK).body("Deleted successfully....");
    }
}
