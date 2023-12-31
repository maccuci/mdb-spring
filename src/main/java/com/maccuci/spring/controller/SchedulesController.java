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
    public ResponseEntity<ScheduleEntity> createSchedule(@RequestBody ScheduleEntity schedule) {
       ScheduleEntity newSchedule =  scheduleService.saveSchedule(schedule);
       return ResponseEntity.ok(newSchedule);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleEntity> findCustomerById(@PathVariable Long id) {
        ScheduleEntity schedule = scheduleService.findSchedule(id);
        return schedule != null ? ResponseEntity.ok(schedule) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleEntity> updateSchedule(@PathVariable Long id, @RequestBody ScheduleEntity schedule) {
        ScheduleEntity existingSchedule = scheduleService.findSchedule(id);

        if (existingSchedule == null) {
            return ResponseEntity.notFound().build();
        }
        existingSchedule.setEmailOwner(schedule.getEmailOwner());
        existingSchedule.setService(schedule.getService());
        existingSchedule.setDate(schedule.getDate());
        existingSchedule.setPrice(schedule.getPrice());

        ScheduleEntity updatedSchedule = scheduleService.saveSchedule(existingSchedule);
        return ResponseEntity.ok(updatedSchedule);
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
