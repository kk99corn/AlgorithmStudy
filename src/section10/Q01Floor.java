package section10;

import java.util.*;

/*
section: 10-01
title: 계단오르기
*/

public class Q01Floor {

    public int getCount(int n) {
        if (n == 0 || n == 1) return 1;

        int[] dp = new int[n + 1]; // 0부터 n까지
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // 핵심 점화식
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Q01Floor t = new Q01Floor();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println(t.getCount(n));
    }
}