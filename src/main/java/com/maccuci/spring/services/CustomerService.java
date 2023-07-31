package com.maccuci.spring.services;

import com.maccuci.spring.entity.CustomerEntity;
import com.maccuci.spring.entity.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerEntity saveCustomer(CustomerEntity customer) {
        return repository.save(customer);
    }

    public CustomerEntity findCustomer(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<CustomerEntity> getAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
