package com.example.demo.core.dtos;

import java.util.UUID;

import com.example.demo.core.entitys.Classroom;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class ClassroomDto {

    @JsonProperty(access = Access.READ_ONLY)
    private UUID id;

    private String name;

    private Integer capaciy;

    public ClassroomDto(Classroom classroom) {
        id = classroom.getId();
        name = classroom.getName();
        capaciy = classroom.getCapacity();
    }

    public Classroom toClassroom() {
        return Classroom.builder()
                .name(name)
                .capacity(capaciy)
                .build();
    }

    @JsonIgnore
    public boolean isValid(){
        return name != null && capaciy != null;
    }
}
