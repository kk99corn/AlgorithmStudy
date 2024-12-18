package section01;

import java.util.Scanner;

/*
section: 01-02
title: 대소문자 변환
[설명]
대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.

[입력]
첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
문자열은 영어 알파벳으로만 구성되어 있습니다.

[출력]
첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
*/
public class Q02ConvertUppperLower {

    public String solution(String str) {
        String answer = "";
        for (char c : str.toCharArray()) {
            // if ((int) c >= 65 && (int) c <= 96) {
            //     answer += Character.toLowerCase(c);
            // } else {
            //     answer += Character.toUpperCase(c);
            // }

            answer += (Character.isUpperCase(c)) ? Character.toLowerCase(c) : Character.toUpperCase(c);
        }
        return answer;
    }

    public static void main(String[] args) {
        Q02ConvertUppperLower t = new Q02ConvertUppperLower();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        System.out.println(t.solution(str));
    }
}
