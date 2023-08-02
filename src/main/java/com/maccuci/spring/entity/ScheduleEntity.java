package com.maccuci.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "schedules")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email_owner")
    private String emailOwner;

    private String service;
    private Date date;
    private Double price;

    public ScheduleEntity(String emailOwner, String service, Date date, Double price) {
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
