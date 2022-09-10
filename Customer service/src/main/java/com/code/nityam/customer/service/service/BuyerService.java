package com.code.nityam.customer.service.service;

import com.code.nityam.customer.service.domain.Buyer;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BuyerService {
    Optional<Buyer> saveSeller(Buyer seller);
    Optional<Page<Buyer>> findFirstName(String firstName, int pageNumber);
    Optional<Page<Buyer>> findLastName(String lastName,int pageNumber);
    Optional<Buyer> findAddress(String address);
    Optional<Page<Buyer>> findCity(String city, int pageNumber);
    Optional<Page<Buyer>> findState(String state,int pageNumber);
    Optional<Buyer> findPin(String pin);
    Optional<Buyer> findPhone(String phone);
    Optional<Buyer> findEmail(String email);
    Optional<Buyer> update(Buyer seller);
    void deleteId(Long id);
    void delete(Buyer seller);

    Optional<Buyer> findUserById(Long id);
}
