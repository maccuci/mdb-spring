package com.maccuci.spring.services;

import com.maccuci.spring.entity.CustomerEntity;
import com.maccuci.spring.entity.ScheduleEntity;
import com.maccuci.spring.entity.dao.CustomerRepository;
import com.maccuci.spring.entity.dao.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleRepository repository;

    @Autowired
    public ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    public ScheduleEntity saveSchedule(ScheduleEntity schedule) {
        return repository.save(schedule);
    }

    public ScheduleEntity findSchedule(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<ScheduleEntity> getAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
