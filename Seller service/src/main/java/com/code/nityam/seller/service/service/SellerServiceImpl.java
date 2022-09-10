package com.code.nityam.seller.service.service;

import com.code.nityam.seller.service.domain.Seller;
import com.code.nityam.seller.service.repo.SellerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {
    private final SellerRepo sellerRepo;

    @Override
    public Optional<Seller> saveSeller(Seller seller) {
        return Optional.of(sellerRepo.save(seller));
    }

    @Override
    public Optional<Page<Seller>> findFirstName(String firstName, int pageNumber) {
        return sellerRepo.findByFirstName(firstName, PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Page<Seller>> findLastName(String lastName, int pageNumber) {
        return sellerRepo.findByLastName(lastName,PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Seller> findAddress(String address) {
        return sellerRepo.findByAddress(address);
    }

    @Override
    public Optional<Page<Seller>> findCity(String city, int pageNumber) {
        return sellerRepo.findByCity(city,PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Page<Seller>> findState(String state, int pageNumber) {
        return sellerRepo.findByState(state,PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Seller> findPin(String pin) {
        return sellerRepo.findByPin(pin);
    }

    @Override
    public Optional<Seller> findPhone(String phone) {
        return sellerRepo.findByPhone(phone);
    }

    @Override
    public Optional<Seller> findEmail(String email) {
        return sellerRepo.findByEmail(email);
    }

    @Override
    public Optional<Seller> update(Seller seller) {
        Optional<Seller> sell = sellerRepo.findByEmail(seller.getEmail());
        if (sell.isPresent()){
            sell.get().setFirstName(seller.getFirstName());
            sell.get().setLastName(seller.getLastName());
            sell.get().setAddress(seller.getAddress());
            sell.get().setCity(seller.getCity());
            sell.get().setState(seller.getState());
            sell.get().setPin(seller.getPin());
            sell.get().setPhone(seller.getPhone());
            sell.get().setEmail(seller.getEmail());
        }
        return sell;
    }

    @Override
    public void deleteId(Long id) {
        sellerRepo.deleteById(id);
    }

    @Override
    public void delete(Seller seller) {
        sellerRepo.delete(seller);
    }
}
