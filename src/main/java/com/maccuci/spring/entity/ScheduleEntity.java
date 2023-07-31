package com.maccuci.spring.entity;

import jakarta.persistence.Column;
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
    @Column(name = "email_owner")
    private String emailOwner;
    private String service;
    private Long date;
    private Double price;

    public ScheduleEntity(String emailOwner, String service, Long date, Double price) {
        this.emailOwner = emailOwner;
        this.service = service;
        this.date = date;
        this.price = price;
    }

    public ScheduleEntity() {}

    public void setId(Long id) {
        this.id = id;
    }
}
