package com.exam.service;

import com.exam.model.Student;
import com.exam.model.Room;

import java.util.*;

public class RoomAllocator {

    public Map<String, String> allocateRooms(
            Map<String, Integer> schedule,
            List<Student> students,
            List<Room> rooms) {

        // Count students per subject
        Map<String, Integer> subjectCount = new HashMap<>();

        for (Student student : students) {
            for (String subject : student.getSubjects()) {
                subjectCount.put(subject,
                        subjectCount.getOrDefault(subject, 0) + 1);
            }
        }

        Map<String, String> allocation = new HashMap<>();

        // Track which rooms are used per slot
        Map<Integer, Set<String>> slotRoomUsage = new HashMap<>();

        for (String subject : schedule.keySet()) {

            int slot = schedule.get(subject);
            int requiredSeats = subjectCount.getOrDefault(subject, 0);

            slotRoomUsage.putIfAbsent(slot, new HashSet<>());

            for (Room room : rooms) {

                boolean roomAvailable =
                        !slotRoomUsage.get(slot).contains(room.getRoomId());

                if (room.getCapacity() >= requiredSeats && roomAvailable) {

                    allocation.put(subject, room.getRoomId());
                    slotRoomUsage.get(slot).add(room.getRoomId());
                    break;
                }
            }
        }

        return allocation;
    }
}