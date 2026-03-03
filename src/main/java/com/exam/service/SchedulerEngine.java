package com.exam.service;

import com.exam.model.Room;
import com.exam.model.Student;

import java.util.*;

public class SchedulerEngine {

    public void run(List<Student> students, List<Room> rooms) {

        long startTime = System.currentTimeMillis();

        ConflictGraph conflictGraph = new ConflictGraph();
        Map<String, Set<String>> graph = conflictGraph.buildGraph(students);

        GraphColoring coloring = new GraphColoring();
        Map<String, Integer> schedule = coloring.colorGraph(graph);

        System.out.println("Final Exam Slot Allocation:");
        schedule.forEach((subject, slot) ->
                System.out.println(subject + " -> Slot " + slot)
        );

        RoomAllocator allocator = new RoomAllocator();
        Map<String, String> roomAllocation =
                allocator.allocateRooms(schedule, students, rooms);

        System.out.println("\nRoom Allocation:");
        roomAllocation.forEach((subject, roomId) ->
                System.out.println(subject + " -> Room " + roomId)
        );

        // ===== METRICS =====

        int totalSubjects = schedule.size();
        int totalSlotsUsed = new HashSet<>(schedule.values()).size();

        int totalCapacity = rooms.stream().mapToInt(Room::getCapacity).sum();
        int totalStudents = students.size();

        double utilization = (double) totalStudents / totalCapacity * 100;

        long endTime = System.currentTimeMillis();

        System.out.println("\n===== Scheduling Metrics =====");
        System.out.println("Total Subjects: " + totalSubjects);
        System.out.println("Total Slots Used: " + totalSlotsUsed);
        System.out.println("Room Utilization: " + String.format("%.2f", utilization) + "%");
        System.out.println("Execution Time: " + (endTime - startTime) + " ms");
    }
}