package section02;

import java.util.*;

/*
section: 02-10
title: 봉우리
[설명]
지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
격자의 가장자리는 0으로 초기화 되었다고 가정한다.
만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.

[입력]
첫 줄에 자연수 N이 주어진다.(2<=N<=50)
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.

[출력]
봉우리의 개수를 출력하세요.
*/
public class Q10Mountain {

    public int solution(int n, int[][] board) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean isMountain = true;
                if (i - 1 >= 0 && board[i][j] <= board[i - 1][j]) isMountain = false;
                if (j - 1 >= 0 && board[i][j] <= board[i][j - 1]) isMountain = false;
                if (i + 1 < n && board[i][j] <= board[i + 1][j]) isMountain = false;
                if (j + 1 < n && board[i][j] <= board[i][j + 1]) isMountain = false;

                if (isMountain) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Q10Mountain t = new Q10Mountain();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        System.out.println(t.solution(n, board));
        sc.close();
    }
}
