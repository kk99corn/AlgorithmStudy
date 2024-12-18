package section02;

import java.util.*;

/*
section: 02-05
title: 소수(에라토스테네스 체)
[설명]
자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.

[입력]
첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.

[출력]
첫 줄에 소수의 개수를 출력합니다.
*/
public class Q05SieveOfEratosthenes {

    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++){
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) answer++;
        }

        return answer;
    }

    public int stdSolution(int n) {
        int answer = 0;
        int[] check = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (check[i] == 0) {
                answer++;
                for (int j = i; j <= n; j = j + i) check[j] = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Q05SieveOfEratosthenes t = new Q05SieveOfEratosthenes();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(t.solution(n));
        System.out.println(t.stdSolution(n));
        sc.close();
    }
}
