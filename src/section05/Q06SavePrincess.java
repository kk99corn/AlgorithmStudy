package section05;

import java.util.*;

/*
section: 05-06
title: 공주 구하기
url: https://cote.inflearn.com/contest/10/problem/05-06
*/
public class Q06SavePrincess {

    public int solution(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            for (int i = 0; i < k; i++) {
                int x = q.poll();
                if (i != k - 1) {
                    q.add(x);
                }
            }
        }

        return q.poll();
    }

    public static void main(String[] args) {
        Q06SavePrincess t = new Q06SavePrincess();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(t.solution(n, k));
        sc.close();
    }
}