package com.example.demo.core.entitys;

import java.util.List;
import java.util.UUID;

import com.example.demo.infra.converters.SemesterConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
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
@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "subject_id")
    private UUID id;

    private String name;

    private Integer credit;

    @Convert(converter = SemesterConverter.class)
    private Semester semester;

    @ManyToMany
    @JoinTable(name = "dependent_subject", 
    joinColumns = @JoinColumn(name = "id"))
    private List<Subject> dependentsSubjects;

    @ManyToMany()
    @JoinTable(joinColumns = @JoinColumn(name = "subject_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> graduatedStudents;

    public void setId(UUID id){
        this.id = id;
    }

}
