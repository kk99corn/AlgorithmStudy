package section02;

import java.util.*;

/*
section: 02-02
title: 가위 바위 보
[설명]
A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
예를 들어 N=5이면
두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.

[입력]
첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.

[출력]
각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
*/
public class Q03RockPaperScissors {

    public void solution(int n, int[] dataA, int[] dataB) {
        int[] rules = {0, 1, 2, 3, 1};

        for (int i = 0; i < n; i++) {
            if (dataA[i] == dataB[i]) {
                System.out.println("D");
            } else {
                if (rules[dataB[i] + 1] == dataA[i]) {
                    System.out.println("A");
                } else {
                    System.out.println("B");
                }
            }
        }
    }

    public static void main(String[] args) {
        Q03RockPaperScissors t = new Q03RockPaperScissors();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dataA = new int[n];
        int[] dataB = new int[n];

        for (int i = 0; i < n; i++) dataA[i] = sc.nextInt();
        for (int i = 0; i < n; i++) dataB[i] = sc.nextInt();

        // System.out.println(t.solution(n, dataA, dataB));
        t.solution(n, dataA, dataB);
        sc.close();
    }
}