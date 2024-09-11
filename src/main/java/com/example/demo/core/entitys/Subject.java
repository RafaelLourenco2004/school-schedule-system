package com.example.demo.core.entitys;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "suject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private Integer credit;

    private String semester;

    @ManyToMany
    @JoinTable(name = "dependent_subject", 
    joinColumns = @JoinColumn(name = "id"))
    private List<Subject> dependentsSubjects;
    // inverseJoinColumns = @JoinColumn(name = "id"))
}
