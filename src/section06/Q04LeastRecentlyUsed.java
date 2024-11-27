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
        sc.close();
    }
}