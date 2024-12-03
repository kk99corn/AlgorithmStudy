package section06;

import java.util.*;

/*
section: 06-07
title: 좌표 정렬
url: https://cote.inflearn.com/contest/10/problem/06-07
*/
public class Q07DotSort {

    class Dot implements Comparable<Dot> {
        int x;
        int y;

        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Dot dot) {
            if (x == dot.x) {
                return y - dot.y;
            } else {
                return x - dot.x;
            }
        }
    }

    public void solution(int n, int[][] arr) {
        List<Dot> list = new ArrayList<>();
        for (int[] a : arr) {
            list.add(new Dot(a[0], a[1]));
        }

        Collections.sort(list);
        for (Dot dot : list) {
            System.out.println(dot.x + " " + dot.y);
        }
    }

    public static void main(String[] args) {
        Q07DotSort t = new Q07DotSort();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        t.solution(n, arr);
        sc.close();
    }
}