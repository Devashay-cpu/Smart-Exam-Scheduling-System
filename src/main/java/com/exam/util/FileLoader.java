package com.exam.util;

import com.exam.model.Room;
import com.exam.model.Student;

import java.io.*;
import java.util.*;

public class FileLoader {

    public static List<Student> loadStudents(String fileName) throws IOException {

        List<Student> students = new ArrayList<>();

        InputStream inputStream =
                FileLoader.class.getClassLoader().getResourceAsStream(fileName);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null) {

            String[] parts = line.split(":");
            String id = parts[0];
            List<String> subjects = Arrays.asList(parts[1].split(","));
            students.add(new Student(id, subjects));
        }

        return students;
    }

    public static List<Room> loadRooms(String fileName) throws IOException {

        List<Room> rooms = new ArrayList<>();

        InputStream inputStream =
                FileLoader.class.getClassLoader().getResourceAsStream(fileName);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null) {

            String[] parts = line.split(":");
            String roomId = parts[0];
            int capacity = Integer.parseInt(parts[1]);
            rooms.add(new Room(roomId, capacity));
        }

        return rooms;
    }
}