package org.practice.graph;

import java.util.*;

public class CourseScheduler {

    public static void main(String[] args) {
        int n = 5;
        //int[][] preReq = {{1, 0}, {2, 1}, {2, 5}, {0, 3}, {4, 3}, {3, 5}, {4, 5}};
        //int[][] preReq = {{1, 0}, {0, 1}};
        //int[][] preReq = {{2,0},{1,0},{3,1},{3,2},{1,3}};
        int[][] preReq = {{1,4},{2,4},{3,1},{3,2}};
        System.out.println("Can Finish: " + new CourseScheduler().canFinish(n, preReq));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] preReq : prerequisites) {
            int from = preReq[1];
            int to = preReq[0];
            graph.get(from).add(to);
        }

        for (int i = 0; i < graph.size(); i++) {
            if (!bfs(graph, i)) {
                return false;
            }
        }
        return true;
        //return dfs(graph, 0, new HashSet<>());
    }

    private boolean bfs (List<List<Integer>> graph, int element) {

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> seen = new HashSet<>();
        queue.add(element);
        List<Integer> nextElements = graph.get(element);
        queue.addAll(nextElements);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            seen.add(num);
            if (num == element) {
                return false;
            }
            List<Integer> adjacent = graph.get(num);
            if (!adjacent.isEmpty()) {
                for (int i : adjacent) {
                    if (!seen.contains(i)) {
                        queue.add(i);
                    }
                }
            }
        }
        return true;
    }

    private boolean dfs (List<List<Integer>> graph, int element, Set<Integer> seen) {
        if (seen.contains(element)) {
            return false;
        }
        seen.add(element);
        List<Integer> nextElements = graph.get(element);
        for (int next : nextElements) {
            return dfs(graph, next, seen);
        }
        return true;
    }
}
