package com.example.demo.core.entitys;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity()
@Table(name = "suject")
public class Subject {

    @Column(name = "subject_id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private Integer credit;

    @Enumerated(EnumType.STRING)
    private Semester semester;

    @ManyToMany
    @JoinTable(name = "dependent_subject", 
    joinColumns = @JoinColumn(name = "id"))
    private List<Subject> dependentsSubjects;

    @ManyToMany()
    @JoinTable(joinColumns = @JoinColumn(name = "subject_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> graduatedStudents;

}
