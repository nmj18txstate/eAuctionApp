package com.code.nityam.seller.service.service;

import com.code.nityam.seller.service.domain.Seller;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface SellerService {
    Optional<Seller> saveSeller(Seller seller);
    Optional<Page<Seller>> findFirstName(String firstName, int pageNumber);
    Optional<Page<Seller>> findLastName(String lastName,int pageNumber);
    Optional<Seller> findAddress(String address);
    Optional<Page<Seller>> findCity(String city, int pageNumber);
    Optional<Page<Seller>> findState(String state,int pageNumber);
    Optional<Seller> findPin(String pin);
    Optional<Seller> findPhone(String phone);
    Optional<Seller> findEmail(String email);
    Optional<Seller> update(Seller seller);
    void deleteId(Long id);
    void delete(Seller seller);
}
