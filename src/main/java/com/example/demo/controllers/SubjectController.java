package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.core.dtos.SubjectDto;
import com.example.demo.core.useCases.subject.SubjectUseCase;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectUseCase subjectUseCase;

    @PostMapping()
    public ResponseEntity<SubjectDto> create(@RequestBody SubjectDto subjectDto) {
        SubjectDto subject = subjectUseCase.create(subjectDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(subject);
    }

    @GetMapping
    public List<SubjectDto> getAll(){
        return subjectUseCase.getAll();
    }
}
