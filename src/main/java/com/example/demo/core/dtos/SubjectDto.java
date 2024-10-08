package com.example.demo.core.dtos;

import java.util.UUID;

import com.example.demo.core.entitys.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class SubjectDto {

    @JsonProperty(access = Access.READ_ONLY)
    private UUID id;

    private String name;

    private Integer credit;

    private String semester;

    public SubjectDto(Subject subject) {
        id = subject.getId();
        name = subject.getName();
        credit = subject.getCredit();
        semester = subject.getSemester().getSemester();
    }

    public Subject toSubject() {
        Subject subject = new Subject();
        subject.setName(name);
        return subject;
    }

    @JsonIgnore
    public boolean isValid(){
        return name != null && credit != null && semester != null;
    }

}
