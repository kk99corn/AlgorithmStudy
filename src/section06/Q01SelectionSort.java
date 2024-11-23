package section06;

import java.util.*;

/*
section: 06-01
title: 선택정렬
url: https://cote.inflearn.com/contest/10/problem/06-01
*/
public class Q01SelectionSort {

    public void solution(int n, int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Q01SelectionSort t = new Q01SelectionSort();
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