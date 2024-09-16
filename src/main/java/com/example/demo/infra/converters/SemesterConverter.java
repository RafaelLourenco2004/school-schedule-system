package com.example.demo.infra.converters;

import org.springframework.stereotype.Component;

import com.example.demo.core.entitys.Semester;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Component
@Converter(autoApply = true)
public class SemesterConverter implements AttributeConverter<Semester, String>{

    private static final String key = "2"; 
    
    @Override
    public String convertToDatabaseColumn(Semester semester) {
        if (semester == null) return null;
        System.out.println(semester.getSEMESTER()+"AQUIIIII");
        // return semester.getSEMESTER().trim();
        return key;
    }

    @Override
    public Semester convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        return Semester.valueOf(dbData);
    }

   
}
