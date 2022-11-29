package org.practice.graph;

import java.util.*;

public class NetworkDelay2 {

    public static void main(String[] args) {
        int n = 5;
        int k = 1;
        int[][] times = {{1,2,9},{1,4,2},{2,5,1},{4,2,4},{4,5,6},{3,2,3},{5,3,7},{3,1,5}};

        /*int n = 4;
        int k = 2;
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};*/

        /*int n = 2;
        int k = 2;
        int[][] times = {{1,2,1}};*/

        /*int n = 4;
        int k = 1;
        int[][] times = {{1,2,1},{2,3,7},{1,3,4},{2,1,2}};*/

        NetworkDelay2 networkDelay = new NetworkDelay2();
        System.out.println("Total time to notify: " + networkDelay.networkDelayTime(times, n, k));
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> directions = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for(int[] time : times) {
            if(!directions.containsKey(time[0])) {
                List<int[]> l = new LinkedList();
                l.add(time);
                directions.put(time[0],l);
            } else {
                List<int[]> lk =directions.get(time[0]);
                lk.add(time);
                directions.put(time[0],lk);
            }
        }

        int[] d = new int[n+1];
        Arrays.fill(d,10000);
        d[k]=0;


        pq.add(new int[]{k,d[k]});

        HashSet<Integer> processed = new HashSet();

        while(pq.size()!=0)
        {
            int[] current =pq.poll();
            int u =current[0];

            if(processed.contains(u)) continue;

            processed.add(u);

            if(directions.containsKey(u))
                for(int[] nodes : directions.get(u)) {
                    int v = nodes[1];
                    int distance = nodes[2];
                    if(d[v] > d[u] + distance)
                        d[v] = d[u] + distance;
                    pq.add(new int[]{v,d[v]});
                }
        }

        int max=0;
        for(int i=1;i<d.length;i++)
        {
            if(i != k) {
                max = Math.max(max, d[i]);
            }
        }

        if(processed.size()!=n) return -1;
        else return max;
    }
}
