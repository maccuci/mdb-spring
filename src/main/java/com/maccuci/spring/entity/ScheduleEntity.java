package com.maccuci.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedules")
public class ScheduleEntity {

    @Id
    private Long id;

    public ScheduleEntity() {}

    public void setId(Long id) {
        this.id = id;
    }
}
