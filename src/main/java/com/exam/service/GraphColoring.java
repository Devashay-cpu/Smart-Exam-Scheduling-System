package com.exam.service;

import java.util.*;

public class GraphColoring {

    public Map<String, Integer> colorGraph(Map<String, Set<String>> graph) {

        Map<String, Integer> result = new HashMap<>();

        // Step 1: Sort subjects by highest degree (descending)
        List<String> subjects = new ArrayList<>(graph.keySet());

        subjects.sort((a, b) ->
                graph.get(b).size() - graph.get(a).size()
        );

        // Step 2: Apply greedy coloring
        for (String subject : subjects) {

            Set<Integer> usedSlots = new HashSet<>();

            for (String neighbor : graph.get(subject)) {
                if (result.containsKey(neighbor)) {
                    usedSlots.add(result.get(neighbor));
                }
            }

            int slot = 1;
            while (usedSlots.contains(slot)) {
                slot++;
            }

            result.put(subject, slot);
        }

        return result;
    }
}