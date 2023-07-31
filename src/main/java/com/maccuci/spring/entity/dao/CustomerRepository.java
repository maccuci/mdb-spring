package com.maccuci.spring.entity.dao;

import com.maccuci.spring.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {}
