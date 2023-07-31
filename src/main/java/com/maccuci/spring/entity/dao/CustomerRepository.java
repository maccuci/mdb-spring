package com.maccuci.spring.entity.dao;

import com.maccuci.spring.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {}
