package com.example.demo.core.entitys;

import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "period")
public class Period {

    @Column(name = "period_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    private Weekend weekDay;

    private LocalTime time;
}
