package com.example.demo.services.subject;

import java.util.List;

import com.example.demo.core.entitys.Subject;

public interface SubjectService {
    
    Subject create(Subject subject);
    List<Subject> getAll();
}
