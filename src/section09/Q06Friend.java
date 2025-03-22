package section09;

import java.util.*;

/*
section: 09-06
title: 친구관계
9 7
 1 2
 2 3
 3 4
 1 5
 6 7
 7 8
 8 9
 3 8
*/

public class Q06Friend {

    static boolean[] isVisit;
    static List<List<Integer>> graph;

    public void solution(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        isVisit[v] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int x : graph.get(current)) {
                if (!isVisit[x]) {
                    isVisit[x] = true;
                    q.offer(x);
                }
            }
        }
    }

    public static void main(String[] args) {
        Q06Friend t = new Q06Friend();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        isVisit = new boolean[n + 1];
        Arrays.fill(isVisit, false);

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        int s = sc.nextInt();
        int e = sc.nextInt();

        sc.close();

        t.solution(s);
        String answer = (isVisit[e]) ? "YES" : "NO";
        System.out.println(answer);
    }
}