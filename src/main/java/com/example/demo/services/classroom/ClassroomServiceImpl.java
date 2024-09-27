package com.example.demo.services.classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.core.entitys.Classroom;
import com.example.demo.repositories.ClassroomRepository;


@Service
public class ClassroomServiceImpl implements ClassroomService{

    @Autowired
    private ClassroomRepository repository;
    
    @Override
    public Classroom create(Classroom classroom) {
        return repository.save(classroom);
    }
    
}
