package section05;

import java.util.*;

/*
section: 05-01
title: 올바른 괄호

[설명]
괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.

[입력]
첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.

[출력]
첫 번째 줄에 YES, NO를 출력한다.
*/
public class Q01CorrectParentheses {

    public String solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return "NO";
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Q01CorrectParentheses t = new Q01CorrectParentheses();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(t.solution(s));
        sc.close();
    }
}