package com.example.demo.services.subject;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.core.entitys.Subject;
import com.example.demo.repositories.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{

    private SubjectRepository repository;
    
    public SubjectServiceImpl(SubjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subject create(Subject subject) {
        return repository.save(subject);
    }

    @Override
    public List<Subject> getAll() {
       return repository.findAll();
    }
    
}
