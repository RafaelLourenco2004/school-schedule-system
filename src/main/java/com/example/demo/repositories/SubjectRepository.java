package com.example.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.core.entitys.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, UUID> {

}
