package section02;

import java.util.*;

/*
section: 02-04
title: 피보나치
[설명]
1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.

[입력]
첫 줄에 총 항수 N(3<=N<=45)이 입력된다.

[출력]
첫 줄에 피보나치 수열을 출력합니다.
*/
public class Q04Fibonacci {

    public String solution(int n) {
        String answer = "";
        int prev = 0;
        int curr = 1;

        for (int i = 0; i < n; i++) {
            answer += (curr) + " ";
            int tmp = curr;
            curr = prev + curr;
            prev = tmp;
        }

        return answer;
    }

    public static void main(String[] args) {
        Q04Fibonacci t = new Q04Fibonacci();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(t.solution(n));
        sc.close();
    }
}
