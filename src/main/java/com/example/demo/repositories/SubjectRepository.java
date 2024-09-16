package com.example.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// import com.example.demo.core.entitys.Semester;
import com.example.demo.core.entitys.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, UUID> {

    @Query(value = "INSERT INTO subject (subject_id, name, semester, credit) VALUES " +
            "(:subject_id, :name, CAST(:semester as semester_enum), :credit)", nativeQuery = true)
    Subject create(@Param("subject_id") UUID id, @Param("name") String name,
            @Param("semester") String semester, @Param("credit") Integer credit);
}
