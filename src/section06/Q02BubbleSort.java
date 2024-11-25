package section06;

import java.util.*;

/*
section: 06-02
title: 버블정렬
url: https://cote.inflearn.com/contest/10/problem/06-02
*/
public class Q02BubbleSort {

    public void solution(int n, int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Q02BubbleSort t = new Q02BubbleSort();
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