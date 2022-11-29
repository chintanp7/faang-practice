package org.practice.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TimeToInform {

    public static void main(String[] args) {

        int n = 8;
        int headId = 4;
        int[] manager = {2, 2, 4, 6, -1, 4, 4, 5};
        int[] informTime = {0, 0, 4, 0, 7, 3, 6, 0};
        TimeToInform timeToInform = new TimeToInform();
        System.out.println("Time to inform all employees: " + timeToInform.numOfMinutes(n, headId, manager, informTime));
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < manager.length; i++) {
            int managerIndex = manager[i];
            if (managerIndex >= 0) {
                graph.get(managerIndex).add(i);
            }
        }

        Set<Integer> seen = new HashSet<>();
        return bfs(graph, headID, seen, informTime);

    }

    private int bfs(List<List<Integer>> graph, int element, Set<Integer> seen, int[] informTime) {
        int max = 0;
        if (!seen.contains(element)) {
            seen.add(element);

            for (int i : graph.get(element)) {
                int value = bfs(graph, i, seen, informTime);
                if (value > max) {
                    max = value;
                }
            }
        }
        return informTime[element] + max;
    }

}
