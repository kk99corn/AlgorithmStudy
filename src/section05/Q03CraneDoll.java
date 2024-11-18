package section05;

import java.util.*;

/*
section: 05-03
title: 크레인 인형뽑기(카카오)
url: https://cote.inflearn.com/contest/10/problem/05-03
*/
public class Q03CraneDoll {

    public int solution(int n, int[][] board, int m, int[] arr) {
        int answer = 0;

        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new Stack<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (board[j][i] != 0) map.get(i + 1).push(board[j][i]);
            }
        }

        Stack<Integer> bucket = new Stack<>();
        for (int i : arr) {
            if (!map.get(i).isEmpty()) {
                int x = map.get(i).pop();
                if (!bucket.isEmpty() && bucket.peek() == x) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(x);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Q03CraneDoll t = new Q03CraneDoll();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(t.solution(n, board, m, arr));
        sc.close();
    }
}