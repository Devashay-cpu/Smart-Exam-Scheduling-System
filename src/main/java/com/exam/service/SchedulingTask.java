package com.exam.service;

import com.exam.model.Room;
import com.exam.model.Student;

import java.util.List;

public class SchedulingTask implements Runnable {

    private List<Student> students;
    private List<Room> rooms;
    private String departmentName;

    public SchedulingTask(String departmentName,
                          List<Student> students,
                          List<Room> rooms) {
        this.departmentName = departmentName;
        this.students = students;
        this.rooms = rooms;
    }

    @Override
    public void run() {

        synchronized (System.out) {
            System.out.println("\n===============================");
            System.out.println("Starting scheduling for: " + departmentName);
            System.out.println("===============================");
        }

        SchedulerEngine engine = new SchedulerEngine();
        engine.run(students, rooms);

        synchronized (System.out) {
            System.out.println("Completed scheduling for: " + departmentName);
            System.out.println("===============================\n");
        }
    }
}