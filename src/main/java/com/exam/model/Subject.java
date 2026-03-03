package com.exam.model;

public class Subject {

    private String name;
    private int priority;

    public Subject(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }
}