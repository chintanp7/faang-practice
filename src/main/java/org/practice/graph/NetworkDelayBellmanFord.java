package org.practice.graph;

import java.util.*;

public class NetworkDelayBellmanFord {

    public static void main(String[] args) {
        /*int n = 5;
        int k = 1;
        int[][] times = {{1,2,9},{1,4,2},{2,5,1},{4,2,4},{4,5,6},{3,2,3},{5,3,7},{3,1,5}};*/

        int n = 5;
        int k = 1;
        int[][] times = {{1,2,9},{3,2,3},{5,3,7},{3,1,5},{2,5,-3},{4,5,6},{1,4,2},{4,2,-5}};

        NetworkDelayBellmanFord networkDelay = new NetworkDelayBellmanFord();
        System.out.println("Total time to notify: " + networkDelay.networkDelayTime(times, n, k));
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[k] = 0;
        d[0] = Integer.MIN_VALUE;
        boolean changed;

        for (int i = 1; i < n; i++) {
            changed = false;
            for (int[] time : times) {
                int from = time[0];
                int to = time[1];
                int weight = time[2];

                if (d[from] != Integer.MAX_VALUE) {
                    if (d[from] + weight < d[to]) {
                        d[to] = d[from] + weight;
                        changed = true;
                    }
                }
            }
            if (!changed) {
                break;
            }
        }

        int max = Arrays.stream(d).max().getAsInt();
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
