package com.code.nityam.customer.service.service;

import com.code.nityam.customer.service.domain.Buyer;
import com.code.nityam.customer.service.repo.BuyerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService{
    private final BuyerRepo sellerRepo;

    @Override
    public Optional<Buyer> saveSeller(Buyer seller) {
        return Optional.of(sellerRepo.save(seller));
    }

    @Override
    public Optional<Page<Buyer>> findFirstName(String firstName, int pageNumber) {
        return sellerRepo.findByFirstName(firstName, PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Page<Buyer>> findLastName(String lastName, int pageNumber) {
        return sellerRepo.findByLastName(lastName,PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Buyer> findAddress(String address) {
        return sellerRepo.findByAddress(address);
    }

    @Override
    public Optional<Page<Buyer>> findCity(String city, int pageNumber) {
        return sellerRepo.findByCity(city,PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Page<Buyer>> findState(String state, int pageNumber) {
        return sellerRepo.findByState(state,PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Buyer> findPin(String pin) {
        return sellerRepo.findByPin(pin);
    }

    @Override
    public Optional<Buyer> findPhone(String phone) {
        return sellerRepo.findByPhone(phone);
    }

    @Override
    public Optional<Buyer> findEmail(String email) {
        return sellerRepo.findByEmail(email);
    }

    @Override
    @Transactional
    public Optional<Buyer> update(Buyer seller) {
        Optional<Buyer> sell = sellerRepo.findByEmail(seller.getEmail());
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
    public void delete(Buyer seller) {
        sellerRepo.delete(seller);
    }

    @Override
    public Optional<Buyer> findUserById(Long id) {
        return sellerRepo.findById(id);
    }
}
