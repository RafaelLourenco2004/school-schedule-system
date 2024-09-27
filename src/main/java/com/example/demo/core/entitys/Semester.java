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

    private final String semester;

    private Semester(String semester) {
        this.semester = semester;
    }

    public static Semester toSemesterEnum(String semester){
        for (Semester sem: Semester.values()){
            if (sem.getSemester().equals(semester))
                return sem;
        }
        return null;
    }

    public String getSemester() {
        return semester;
    }

}
