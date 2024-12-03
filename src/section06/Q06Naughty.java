package section06;

import java.util.*;

/*
section: 06-06
title: 장난꾸러기
url: https://cote.inflearn.com/contest/10/problem/06-06
*/
public class Q06Naughty {

    public void solution(int n, int[] arr) {
        int[] arr2 = Arrays.copyOf(arr, n);
        Arrays.sort(arr2);

        for (int i = 0; i < n; i++) {
            if (arr[i] != arr2[i]) System.out.print((i + 1) + " ");
        }
    }

    public static void main(String[] args) {
        Q06Naughty t = new Q06Naughty();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        t.solution(n, arr);
        sc.close();
    }
}