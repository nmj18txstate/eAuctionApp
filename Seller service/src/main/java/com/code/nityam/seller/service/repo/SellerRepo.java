package com.code.jamie.seller.service.repo;

import com.code.jamie.seller.service.domain.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepo extends JpaRepository<Seller,Long> {
    @Override
    Optional<Seller> findById(Long id);
    Optional<Page<Seller>> findByFirstName(String firstName, Pageable pageable);
    Optional<Page<Seller>> findByLastName(String lastName, Pageable pageable);
    Optional<Seller> findByAddress(String address);
    Optional<Page<Seller>> findByCity(String city, Pageable pageable);
    Optional<Page<Seller>> findByState(String state, Pageable pageable);
    Optional<Seller> findByPin(String pin);
    Optional<Seller> findByPhone(String phone);
    Optional<Seller> findByEmail(String email);
}
