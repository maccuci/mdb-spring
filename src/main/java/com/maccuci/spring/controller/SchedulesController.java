package com.maccuci.spring.controller;

import com.maccuci.spring.entity.ScheduleEntity;
import com.maccuci.spring.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedules")
public class SchedulesController {

   private final ScheduleService scheduleService;

   @Autowired
    public SchedulesController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ScheduleEntity> createScheduele(@RequestBody ScheduleEntity schedule) {
       ScheduleEntity newSchedule =  scheduleService.saveCustomer(schedule);
       return ResponseEntity.ok(newSchedule);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleEntity> findCustomerById(@PathVariable Long id) {
        ScheduleEntity schedule = scheduleService.findCustomer(id);
        return schedule != null ? ResponseEntity.ok(schedule) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Iterable<ScheduleEntity>> list() {
        Iterable<ScheduleEntity> customers = scheduleService.getAll();
        return ResponseEntity.ok(customers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        scheduleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
