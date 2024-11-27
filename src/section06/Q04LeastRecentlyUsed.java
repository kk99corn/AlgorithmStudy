package section06;

import java.util.*;

/*
section: 06-04
title: LRU
url: https://cote.inflearn.com/contest/10/problem/06-04
*/
public class Q04LeastRecentlyUsed {

    public void solution(int s, int n, int[] arr) {
        List<Integer> list = new LinkedList<>();
        for (int i : arr) {
            if (list.contains(i)) {
                list.remove((Integer) i);
            } else {
                if (list.size() == s) {
                    list.remove((Integer) list.get(list.size() - 1));
                }
            }
            list.add(0, i);
        }

        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    public void stdSolution(int s, int n, int[] arr) {
        int[] cache = new int[s];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < s; i++) {
                if (x == cache[i]) {
                    pos = i;
                }
            }

            if (pos == -1) {
                for (int i = s - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
                cache[0] = x;
            } else {
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
                cache[0] = x;
            }
        }

        for (int i : cache) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Q04LeastRecentlyUsed t = new Q04LeastRecentlyUsed();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        t.solution(s, n, arr);
        System.out.println();
        t.stdSolution(s, n, arr);
        sc.close();
    }
}