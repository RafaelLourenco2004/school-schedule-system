package com.example.demo.infra.converters;

import org.springframework.stereotype.Component;

import com.example.demo.core.entitys.Semester;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Component
@Converter(autoApply = true)
public class SemesterConverter implements AttributeConverter<Semester, String> {

    @Override
    public String convertToDatabaseColumn(Semester semester) {
        if (semester == null)
            return null;
        return semester.getSemester().trim();
    }

    @Override
    public Semester convertToEntityAttribute(String semester) {
        if (semester == null)
            return null;

        return Semester.toSemesterEnum(semester);

    }
}
