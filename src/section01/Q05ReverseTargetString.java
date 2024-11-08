package section01;

import java.util.Scanner;

/*
section: 01-05
title: 특정 문자 뒤집기
[설명]
영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.

[입력]
첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.

[출력]
첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
*/
public class Q05ReverseTargetString {

    public String solution(String str) {
        String answer = "";
        
        char[] strArr = str.toCharArray();
        char[] tempArr = new StringBuilder(str).reverse().toString().toCharArray();
        
        int tempIdx = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (Character.isAlphabetic(strArr[i])) {
                while (!Character.isAlphabetic(tempArr[tempIdx])) {
                    tempIdx++;
                }
                strArr[i] = tempArr[tempIdx++];
            }
            answer += strArr[i];
        }

        return answer;
    }

    public String stdSolution(String str) {
        char[] strArr = str.toCharArray();
        int s = 0;
        int e = strArr.length - 1;
        while (s < e) {
            if (!Character.isAlphabetic(strArr[s])) {
                s++;
            } else if (!Character.isAlphabetic(strArr[e])) {
                e--;
            } else {
                char temp = strArr[s];
                strArr[s] = strArr[e];
                strArr[e] = temp;
                s++;
                e--;
            }
        }

        return String.valueOf(strArr);
    }

    public static void main(String[] args) {
        Q05ReverseTargetString t = new Q05ReverseTargetString();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(t.solution(s));
        System.out.println(t.stdSolution(s));
        sc.close();
    }
}
