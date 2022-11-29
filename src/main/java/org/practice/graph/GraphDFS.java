package org.practice.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphDFS {

    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(List.of(1, 3), List.of(0), List.of(3, 8), List.of(0, 2, 4, 5), List.of(3, 6), List.of(3), List.of(4, 7), List.of(6), List.of(2));
        GraphDFS dfs = new GraphDFS();
        List<Integer> values = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        dfs.dfs(graph, 0, values, seen);
        System.out.println("DFS: " + values);
    }

    private void dfs(List<List<Integer>> graph, int element, List<Integer> values, Set<Integer> seen) {
        List<Integer> connections = graph.get(element);
        if (!seen.contains(element)) {
            values.add(element);
            seen.add(element);
            for (int connection : connections) {
                dfs(graph, connection, values, seen);
            }
        }
        /*for (int connection : connections) {
            if (!seen.contains(connection)) {
                values.add(connection);
                seen.add(connection);
                dfs(graph, connection, values, seen);
            }
        }*/
    }
}
