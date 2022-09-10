package com.code.nityam.customer.service.repo;

import com.code.nityam.customer.service.domain.Buyer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer,Long> {
    @Override
    Optional<Buyer> findById(Long id);
    Optional<Page<Buyer>> findByFirstName(String firstName, Pageable pageable);
    Optional<Page<Buyer>> findByLastName(String lastName, Pageable pageable);
    Optional<Buyer> findByAddress(String address);
    Optional<Page<Buyer>> findByCity(String city, Pageable pageable);
    Optional<Page<Buyer>> findByState(String state, Pageable pageable);
    Optional<Buyer> findByPin(String pin);
    Optional<Buyer> findByPhone(String phone);
    Optional<Buyer> findByEmail(String email);
}
