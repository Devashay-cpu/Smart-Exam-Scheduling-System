package com.exam.model;

import java.util.List;

public class Student {

    private String id;
    private List<String> subjects;

    public Student(String id, List<String> subjects) {
        this.id = id;
        this.subjects = subjects;
    }

    public String getId() {
        return id;
    }

    public List<String> getSubjects() {
        return subjects;
    }
}