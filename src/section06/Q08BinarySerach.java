package section06;

import java.util.*;

/*
section: 06-08
title: 이분검색
url: https://cote.inflearn.com/contest/10/problem/06-08
*/
public class Q08BinarySerach {

    public int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == m) {
                idx = i + 1;
                break;
            }
        }

        return idx;
    }

    public int stdSolution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);

        int lt = 0;
        int rt = n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (arr[mid] == m) {
                answer = mid + 1;
            }
            
            if (arr[mid] > m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Q08BinarySerach t = new Q08BinarySerach();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(t.solution(n, m, arr));
        System.out.println(t.stdSolution(n, m, arr));
        sc.close();
    }
}