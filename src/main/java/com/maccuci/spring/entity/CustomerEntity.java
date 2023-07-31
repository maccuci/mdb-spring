package com.maccuci.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "customers")
@Getter
public class CustomerEntity {

    @Getter
    @Id
    private Long id;
    private String email, phone;
    private String name, petName, petService;

    public CustomerEntity() {}

    public CustomerEntity(String email, String phone, String name, String petName, String petService) {
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.petName = petName;
        this.petService = petService;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
