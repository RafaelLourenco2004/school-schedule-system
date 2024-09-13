package com.example.demo.core.entitys;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class LessonID implements Serializable{

    @Column(name = "subject_id")
    private UUID subjectId;

    @Column(name = "class_id")
    private UUID classId;

    public LessonID(UUID subjectId, UUID classId){
        this.subjectId = subjectId;
        this.classId = classId;
    }

    public boolean equals(LessonID lessonID){
        return subjectId.equals(lessonID.getSubjectId()) && classId.equals(lessonID.getClassId());
    }
}
