package com.code.nityam.customer.service.controller;

import com.code.nityam.customer.service.domain.Buyer;
import com.code.nityam.customer.service.service.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/v1/buyer")
@RequiredArgsConstructor
public class BuyerController {
    private final BuyerService buyerService;

    @PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody Buyer buyer) {
        return ResponseEntity.status(CREATED).body(buyerService.saveSeller(buyer));
    }
    @GetMapping(value = "/id/{id}",produces = "application/json")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id")String id){
        return ResponseEntity.status(OK).body(buyerService.findUserById(Long.parseLong(id)));
    }

    @GetMapping(value = "/first_name/{first_name}/{page_number}", produces = "application/json")
    public ResponseEntity<?> findUsingFirstname(@PathVariable(value = "first_name") String firstName, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(buyerService.findFirstName(firstName, Integer.parseInt(pageNumber) - 1));
    }

    @GetMapping(value = "/first_name/{last_name}/{page_number}", produces = "application/json")
    public ResponseEntity<?> findUsingLastname(@PathVariable(value = "last_name") String lastName, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(buyerService.findLastName(lastName, Integer.parseInt(pageNumber) - 1));
    }

    @GetMapping(value = "/address/{address}", produces = "application/json")
    public ResponseEntity<?> findUsingAddress(@PathVariable(value = "address") String address) {
        return ResponseEntity.status(OK).body(buyerService.findAddress(address));
    }

    @GetMapping(value = "/city/{city}/{page_number}", produces = "application/json")
    public ResponseEntity<?> findUsingCity(@PathVariable(value = "city") String city, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(buyerService.findCity(city, Integer.parseInt(pageNumber) - 1));
    }

    @GetMapping(value = "/state/{state}/{page_number}", produces = "application/json")
    public ResponseEntity<?> findUsingState(@PathVariable(value = "state") String state, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(buyerService.findState(state, Integer.parseInt(pageNumber) - 1));
    }

    @GetMapping(value = "/pin/{pin}", produces = "application/json")
    public ResponseEntity<?> findUsingPin(@PathVariable(value = "pin") String pin, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(buyerService.findPin(pin));
    }

    @GetMapping(value = "/phone/{phone}", produces = "application/json")
    public ResponseEntity<?> findUsingPhone(@PathVariable(value = "phone") String phone, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(buyerService.findPin(phone));
    }

    @GetMapping(value = "/email/{email}", produces = "application/json")
    public ResponseEntity<?> findUsingEmail(@PathVariable(value = "email") String email, @PathVariable(value = "page_number") String pageNumber) {
        return ResponseEntity.status(OK).body(buyerService.findPin(email));
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateSeller(@RequestBody Buyer buyer) {
        return ResponseEntity.status(ACCEPTED).body(buyerService.update(buyer));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteUsingId(@PathVariable(value = "id") String id) {
        buyerService.deleteId(Long.parseLong(id));
        return ResponseEntity.status(OK).body("Deleted successfully....");
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete(Buyer buyer) {
        buyerService.delete(buyer);
        return ResponseEntity.status(OK).body("Deleted successfully....");
    }
}
