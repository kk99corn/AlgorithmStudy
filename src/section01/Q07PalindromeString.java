package section01;

import java.util.*;

/*
section: 01-07
title: 회문 문자열
[설명]
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
단 회문을 검사할 때 대소문자를 구분하지 않습니다.

[입력]
첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.

[출력]
첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
*/
public class Q07PalindromeString {

    public String solution(String str) {
        return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString()) ? "YES" : "NO";
    }

    public String stdSolution(String str) {
        boolean isPalindrome = true;
        str = str.toUpperCase();

        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Q07PalindromeString t = new Q07PalindromeString();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(t.solution(s));
        System.out.println(t.stdSolution(s));
        sc.close();
    }
}
