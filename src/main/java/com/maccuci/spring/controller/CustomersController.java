package com.maccuci.spring.controller;

import com.maccuci.spring.entity.CustomerEntity;
import com.maccuci.spring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    private final CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer) {
        CustomerEntity newCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.ok(newCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> findCustomerById(@PathVariable Long id) {
        CustomerEntity customer = customerService.findCustomer(id);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Iterable<CustomerEntity>> list() {
        Iterable<CustomerEntity> customers = customerService.getAll();
        return ResponseEntity.ok(customers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
