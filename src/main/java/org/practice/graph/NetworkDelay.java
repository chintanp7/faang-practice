package org.practice.graph;

import java.util.*;

public class NetworkDelay {

    public static void main(String[] args) {
        /*int n = 5;
        int k = 1;
        int[][] times = {{1,2,9},{1,4,2},{2,5,1},{4,2,4},{4,5,6},{3,2,3},{5,3,7},{3,1,5}};*/

        /*int n = 4;
        int k = 2;
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};*/

        /*int n = 2;
        int k = 2;
        int[][] times = {{1,2,1}};*/

        int n = 4;
        int k = 1;
        int[][] times = {{1,2,1},{2,3,7},{1,3,4},{2,1,2}};

        NetworkDelay networkDelay = new NetworkDelay();
        System.out.println("Total time to notify: " + networkDelay.networkDelayTime(times, n, k));
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<Integer>> directions = new LinkedHashMap<>();
        Map<String, Integer> weights = new LinkedHashMap<>();
        Map<Integer, Integer> distances = new LinkedHashMap<>();
        Set<Integer> seen = new HashSet<>();
        List<Integer> nodes = new ArrayList<>();
        int count = 0;

        if (times == null) {
            return 0;
        }

        for (int[] timeArr : times) {
            int from = timeArr[0];
            int to = timeArr[1];
            int time = timeArr[2];

            if (!directions.containsKey(from)) {
                directions.put(from, new ArrayList<>());
                distances.put(from, Integer.MAX_VALUE);
                nodes.add(from);
                count++;
            }
            if (!directions.containsKey(to)) {
                directions.put(to, new ArrayList<>());
                distances.put(to, Integer.MAX_VALUE);
                nodes.add(to);
                count++;
            }
            directions.get(from).add(to);
            weights.put(from + "_" + to, time);
        }

        distances.put(k, 0);
        for (int i = 0; i < n; i++) {
            seen.add(k);
            List<Integer> nextElements = directions.get(k);
            for (int next : nextElements) {
                if (distances.get(k) < Integer.MAX_VALUE) {
                    int distance = distances.get(k) + weights.get(k + "_" + next);
                    if (distances.containsKey(next) && distance < distances.get(next)) {
                        distances.put(next, distance);
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for (int node : nodes) {
                if (!seen.contains(node)) {
                    if (distances.get(node) <= min) {
                        min = distances.get(node);
                        k = node;
                    }
                }
            }
        }
        System.out.println(distances);
        int totalTime = distances.values().stream().mapToInt(v -> v).max().getAsInt();
        return totalTime == Integer.MAX_VALUE ? -1 : totalTime;
    }
}
