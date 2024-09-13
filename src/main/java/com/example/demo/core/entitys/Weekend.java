package com.example.demo.core.entitys;

public enum Weekend {

    MONDAY("segunda"),
    TUESDAY("terça"),
    WEDNESDAY("quarta"),
    THURSDAY("quinta"),
    FRIDAY("sexta"),
    SATURDAY("sabado"),
    SUNDAY("domingo");

    private String day;

    public String getDay() {
        return day;
    }

    private Weekend(String day) {
        this.day = day;
    }

}
