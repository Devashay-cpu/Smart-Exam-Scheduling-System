package com.exam.service;

import com.exam.model.Student;
import java.util.*;

public class ConflictGraph {

    public Map<String, Set<String>> buildGraph(List<Student> students) {

        Map<String, Set<String>> graph = new HashMap<>();

        for (Student student : students) {
            List<String> subjects = student.getSubjects();

            for (int i = 0; i < subjects.size(); i++) {
                for (int j = i + 1; j < subjects.size(); j++) {

                    graph.putIfAbsent(subjects.get(i), new HashSet<>());
                    graph.putIfAbsent(subjects.get(j), new HashSet<>());

                    graph.get(subjects.get(i)).add(subjects.get(j));
                    graph.get(subjects.get(j)).add(subjects.get(i));
                }
            }
        }
        return graph;
    }
}