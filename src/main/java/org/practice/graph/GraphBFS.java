package org.practice.graph;

import java.util.*;

public class GraphBFS {

    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(List.of(1, 3), List.of(0), List.of(3, 8), List.of(0, 2, 4, 5), List.of(3, 6), List.of(3), List.of(4, 7), List.of(6), List.of(2));
        GraphBFS bfs = new GraphBFS();
        System.out.println("BFS: " + bfs.bfs(graph));
    }

    private List<Integer> bfs(List<List<Integer>> graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> values = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int element = queue.poll();
            values.add(element);
            seen.add(element);
            List<Integer> connections = graph.get(element);
            for (int connection : connections) {
                if (!seen.contains(connection)) {
                    queue.add(connection);
                }
            }
        }
        return values;
    }

    private void dfs(List<List<Integer>> graph, int element, List<Integer> values, Set<Integer> seen) {
        List<Integer> connections = graph.get(element);
        for (int connection : connections) {
            if (!seen.contains(connection)) {
                values.add(connection);
                seen.add(connection);
                dfs(graph, connection, values, seen);
            }
        }
    }
}
