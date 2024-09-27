package com.example.demo.core.useCases.classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.core.dtos.ClassroomDto;
import com.example.demo.core.entitys.Classroom;
import com.example.demo.core.exceptions.MissingFieldsException;
import com.example.demo.services.classroom.ClassroomService;

@Service
public class ClassroomUseCase {

    @Autowired
    private ClassroomService classroomService;

    public Classroom create(ClassroomDto classroomDto) throws MissingFieldsException{
        isThereMissingFields(classroomDto);
        return null;
    }

    private void isThereMissingFields(ClassroomDto classroom) throws MissingFieldsException{
        if (!classroom.isValid())
            throw new MissingFieldsException("All fields must be provided!");
    }
}
