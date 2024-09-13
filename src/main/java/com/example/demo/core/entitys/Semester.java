package com.example.demo.core.entitys;

public enum Semester {

    FIRST("1"),
    SECOND("2"),
    THIRD("3"),
    FORTH("4"),
    FIFTH("5"),
    SIXTH("6"),
    SEVENTH("7"),
    EIGHTH("8");

    private String semester;

    private Semester(String semester) {
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

}
