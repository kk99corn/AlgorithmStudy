package section05;

import java.util.*;

/*
section: 05-05
title: 쇠막대기
url: https://cote.inflearn.com/contest/10/problem/05-05
*/
public class Q05Stick {

    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        s = s.replaceAll("\\(\\)", "*");

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    stack.pop();
                    answer++;
                    break;
                case '*':
                    answer += stack.size();
                    break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Q05Stick t = new Q05Stick();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(t.solution(s));
        sc.close();
    }
}