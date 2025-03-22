package section09;

import java.util.*;

/*
section: 09-05
title: 다익스트라
6 9
 1 2 12
 1 3 4
 2 1 2
 2 3 5
 2 5 5
 3 4 5
 4 2 2
 4 5 5
 6 4 5
*/

class Edge implements Comparable<Edge> {
    int v;
    int cost;

    Edge(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(cost, o.cost);
    }
}

public class Q05Dijkstra {

    static int[] distant;
    static List<List<Edge>> graph;

    public void solution(int v) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(v, 0));
        distant[v] = 0;

        while (!q.isEmpty()) {
            Edge cur = q.poll();
            int curV = cur.v;
            int curCost = cur.cost;
            if (curCost > distant[curV])
                continue;
            for (Edge edge : graph.get(curV)) {
                int cv = edge.v;
                int cost = curCost + edge.cost;
                if (distant[cv] > cost) {
                    distant[cv] = cost;
                    q.offer(new Edge(cv, cost));
                }
            }
        }

    }

    public static void main(String[] args) {
        Q05Dijkstra t = new Q05Dijkstra();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        distant = new int[n + 1];
        Arrays.fill(distant, Integer.MAX_VALUE);

        graph = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(s).add(new Edge(e, cost));
        }

        sc.close();
        t.solution(1);
        for (int i = 2; i <= n; i++) {
            if (distant[i] != Integer.MAX_VALUE)
                System.out.println(i + " : " + distant[i]);
            else
                System.out.println(i + " : impossible");
        }
    }
}