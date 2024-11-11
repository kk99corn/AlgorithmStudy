package section02;

import java.util.*;

/*
section: 02-06
title: 뒤집은 소수
[설명]
N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
첫 자리부터의 연속된 0은 무시한다.

[입력]
첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
각 자연수의 크기는 100,000를 넘지 않는다.

[출력]
첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
*/
public class Q06ReversePrime {

    public void solution(int[] numList) {
        String answer = "";
        for (int i = 0; i < numList.length; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= numList[i]; j++) {
                if (numList[i] % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime && numList[i] > 1) answer += (numList[i] + " ");
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        Q06ReversePrime t = new Q06ReversePrime();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numList = new int[n];

        for (int i = 0; i < n; i++) {
            numList[i] = Integer.parseInt(new StringBuilder(sc.next()).reverse().toString());
        }

        t.solution(numList);
        sc.close();
    }
}
