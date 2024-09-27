package com.example.demo.core.useCases.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.core.dtos.SubjectDto;
import com.example.demo.core.entitys.Semester;
import com.example.demo.core.entitys.Subject;
import com.example.demo.core.exceptions.BadRequestException;
import com.example.demo.core.exceptions.EntityAlreadyExistsException;
import com.example.demo.core.exceptions.MissingFieldsException;
import com.example.demo.infra.converters.SemesterConverter;
import com.example.demo.services.subject.SubjectService;

@Service
public class SubjectUseCase {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SemesterConverter semesterConverter;

    public SubjectDto create(SubjectDto subjectDto) throws MissingFieldsException,
            EntityAlreadyExistsException, BadRequestException {
        isThereMissingFields(subjectDto);
        doesSubjectExist(subjectDto.getName());

        Semester semester = getSemester(subjectDto);
        Integer credit =  getCredit(subjectDto);
        Subject subject = subjectDto.toSubject();
        subject.setSemester(semester);
        subject.setCredit(credit);
        Subject newSubject = subjectService.create(subject);
        return new SubjectDto(newSubject);
    }

    public List<SubjectDto> getAll() {
        List<Subject> subjects = subjectService.getAll();
        List<SubjectDto> subjectDtos = subjects.stream()
                .map((subject) -> new SubjectDto(subject))
                .toList();
        return subjectDtos;
    }

    private void isThereMissingFields(SubjectDto subject) throws MissingFieldsException {
        if (!subject.isValid())
            throw new MissingFieldsException("All fields must be provided");
    }

    private void doesSubjectExist(String name) throws EntityAlreadyExistsException {
        if (subjectService.doesSubjectExist(name))
            throw new EntityAlreadyExistsException(String.format("%s subject alreaady exists", name));
    }

    private Semester getSemester(SubjectDto subject) throws BadRequestException {
        Semester semester = semesterConverter.convertToEntityAttribute(subject.getSemester());
        if (semester == null)
            throw new BadRequestException("Semester must be >= 1 and <=8");
        return semester;
    }

    private Integer getCredit(SubjectDto subject) throws BadRequestException{
        Integer credit = subject.getCredit();
        if (credit <= 0 || credit > 5)
            throw new BadRequestException("Max credit provided for a subject is 5");
        return credit;
    }
}
