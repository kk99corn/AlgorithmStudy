package section02;

import java.util.*;

/*
section: 02-01
title: 큰 수 출력하기
[설명]
N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
(첫 번째 수는 무조건 출력한다)

[입력]
첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.

[출력]
자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
*/
public class Q01PrintBigNum {

    public String solution(int n, String numList) {
        String answer = "";

        int prevNum = Integer.MIN_VALUE;
        for (String num : numList.split(" ")) {
            if (prevNum < Integer.parseInt(num)) answer = answer + (num + " ");
            prevNum = Integer.parseInt(num);
        }

        return answer;
    }

    public static void main(String[] args) {
        Q01PrintBigNum t = new Q01PrintBigNum();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String numList = sc.nextLine();
        System.out.println(t.solution(n, numList));
        sc.close();
    }
}
