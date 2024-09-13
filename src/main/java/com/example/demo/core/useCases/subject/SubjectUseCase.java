package com.example.demo.core.useCases.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.core.dtos.SubjectDto;
import com.example.demo.core.entitys.Subject;
import com.example.demo.core.exceptions.missingfields.MissingFieldsException;
import com.example.demo.services.subject.SubjectService;

@Service
public class SubjectUseCase {

    @Autowired
    private SubjectService subjectService;

    public SubjectDto create(SubjectDto subjectDto) {
        if (subjectDto.isValid())
            throw new MissingFieldsException("All fields must be provided");
        Subject subject = subjectDto.toSubject();
        return new SubjectDto(subject);
    }

    public List<SubjectDto> getAll() {
        List<Subject> subjects = subjectService.getAll();
        List<SubjectDto> subjectDtos = subjects.stream()
                .map((subject) -> new SubjectDto(subject))
                .toList();
        return subjectDtos;
    }
}
