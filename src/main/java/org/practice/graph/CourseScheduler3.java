package org.practice.graph;

import java.util.*;

public class CourseScheduler3 {

    public static void main(String[] args) {
        int n = 6;
        //int[][] preReq = {{1, 0}, {2, 1}, {2, 5}, {0, 3}, {4, 3}, {3, 5}, {4, 5}};
        //int[][] preReq = {{1, 0}, {0, 1}};
        //int[][] preReq = {{2,0},{1,0},{3,1},{3,2},{1,3}};
        //int[][] preReq = {{1,4},{2,4},{3,1},{3,2}};
        //int[][] preReq = {{5,0},{4,0},{4,1},{0,3},{2,3},{3,5}};
        int[][] preReq = {{1,0},{2,1},{2,5},{0,3},{4,3},{3,5},{4,5}};
        System.out.println("Can Finish: " + new CourseScheduler3().canFinish(n, preReq));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites == null || prerequisites.length <= 1) {
            return true;
        }

        List<List<Integer>> graph = new ArrayList<>(numCourses);
        List<Integer> inDegreeList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
            inDegreeList.add(0);
        }

        for (int[] preReq : prerequisites) {
            int to = preReq[0];
            int from = preReq[1];
            graph.get(from).add(to);
            inDegreeList.set(to, inDegreeList.get(to) + 1);
        }

        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < inDegreeList.size(); i++) {
            if (inDegreeList.get(i) == 0) {
                queue.add(i);
            }
        }

        if (queue.isEmpty()) {
            return false;
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (inDegreeList.get(num) == 0) {
                list.add(num);
                List<Integer> adjs = graph.get(num);
                for (int adj : adjs) {
                    inDegreeList.set(adj, inDegreeList.get(adj) - 1);
                    /*if (!queue.contains(adj)) {
                        queue.add(adj);
                    }*/
                    if (inDegreeList.get(adj) == 0) {
                        queue.add(adj);
                    }
                }
            }
            if (list.size() >= numCourses) {
                return true;
            }
        }
        return false;
    }


}
