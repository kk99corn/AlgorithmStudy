package section05;

import java.util.*;

/*
section: 05-02
title: 괄호문자제거

[설명]
입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.

[입력]
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

[출력]
남은 문자만 출력한다.
*/
public class Q02RemoveParentheses {

    public String solution(String s) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            } else {
                if (stack.size() == 0) {
                    answer += c;
                }
            }
        }
        return answer;
    }

    public String stdSolution(String s) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                while (true) {
                    if (stack.pop() == '(') break;
                }
            } else {
                stack.push(c);
            }
        }
        
        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Q02RemoveParentheses t = new Q02RemoveParentheses();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(t.solution(s));
        System.out.println(t.stdSolution(s));
        sc.close();
    }
}