package org.practice.graph;

import java.util.*;

public class CourseScheduler2 {

    public static void main(String[] args) {
        int n = 6;
        //int[][] preReq = {{1, 0}, {2, 1}, {2, 5}, {0, 3}, {4, 3}, {3, 5}, {4, 5}};
        //int[][] preReq = {{1, 0}, {0, 1}};
        //int[][] preReq = {{2,0},{1,0},{3,1},{3,2},{1,3}};
        //int[][] preReq = {{1,4},{2,4},{3,1},{3,2}};
        int[][] preReq = {{5,0},{4,0},{4,1},{0,3},{2,3},{3,5}};
        System.out.println("Can Finish: " + new CourseScheduler2().canFinish(n, preReq));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] preReq : prerequisites) {
            int to = preReq[1];
            int from = preReq[0];
            graph.get(to).add(from);
        }

        Set<Integer> list = new HashSet<>();

        while (true) {
            boolean flag = false;
            for (int i = 0; i < numCourses; i++) {
                if (!list.contains(i)) {
                    if (graph.get(i).isEmpty()) {
                        list.add(i);
                        flag = true;
                        for (int j = 0; j < numCourses; j++) {
                            if (graph.get(j).contains(i)) {
                                graph.get(j).remove(Integer.valueOf(i));
                            }
                        }
                    }
                }
                if (list.size() == numCourses) {
                    return true;
                }
            }
            if (!flag) {
                return false;
            }
        }
    }


}
