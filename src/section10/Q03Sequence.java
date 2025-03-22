package section10;

import java.util.*;

/*
section: 10-03
title: 최대 부분 증가수열
*/

public class Q03Sequence {

    public int getMax(int n, int[] arr) {
        int answer = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int tempMax = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    tempMax = Math.max(tempMax, dp[j]);
                }
            }
            dp[i] = tempMax + 1;
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Q03Sequence t = new Q03Sequence();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(t.getMax(n, arr));
    }
}