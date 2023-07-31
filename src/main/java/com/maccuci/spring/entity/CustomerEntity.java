package com.maccuci.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "customers")
@Getter
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name, email, phone;
    @Column(name = "pet_name")
    private String petName;
    @Column(name = "pet_service")
    private String petService;

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
