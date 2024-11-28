package section06;

import java.util.*;

/*
section: 06-05
title: 중복 확인
url: https://cote.inflearn.com/contest/10/problem/06-05
*/
public class Q05DuplicationCheck {

    public String solution(int n, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        return n == set.size() ? "U" : "D";
    }

    public String stdSolution(int n, int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return "D";
            }
        }

        return "U";
    }

    public static void main(String[] args) {
        Q05DuplicationCheck t = new Q05DuplicationCheck();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(t.solution(n, arr));
        System.out.println(t.stdSolution(n, arr));
        sc.close();
    }
}