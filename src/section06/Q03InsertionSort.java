package section06;

import java.util.*;

/*
section: 06-03
title: 삽입정렬
url: https://cote.inflearn.com/contest/10/problem/06-03
*/
public class Q03InsertionSort {

    public void solution(int n, int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Q03InsertionSort t = new Q03InsertionSort();
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