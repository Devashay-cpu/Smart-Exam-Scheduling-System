package com.exam.main;

import com.exam.model.Room;
import com.exam.model.Student;
import com.exam.service.SchedulingTask;
import com.exam.util.FileLoader;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExamSchedulerApp {

    public static void main(String[] args) throws Exception {

        List<Student> students =
                FileLoader.loadStudents("students.txt");

        List<Room> rooms =
                FileLoader.loadRooms("rooms.txt");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(new SchedulingTask("Department A", students, rooms));
        executor.submit(new SchedulingTask("Department B", students, rooms));
        executor.submit(new SchedulingTask("Department C", students, rooms));

        executor.shutdown();
    }
}