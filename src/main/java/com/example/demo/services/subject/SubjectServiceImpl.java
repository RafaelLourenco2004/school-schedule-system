package com.example.demo.services.subject;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.core.entitys.Subject;
import com.example.demo.infra.converters.SemesterConverter;
import com.example.demo.repositories.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository repository;

    private SemesterConverter semesterConverter;

    public SubjectServiceImpl(SubjectRepository repository, SemesterConverter semesterConverter) {
        this.repository = repository;
        this.semesterConverter = semesterConverter;
    }

    @Override
    public Subject create(Subject subject) {
        String semester = semesterConverter.convertToDatabaseColumn(subject.getSemester());
        System.out.println(subject.getId().toString().toUpperCase());
        return repository.create(
                subject.getId(),
                subject.getName(),
                semester,
                subject.getCredit());
    }

    @Override
    public List<Subject> getAll() {
        return repository.findAll();
    }

}
