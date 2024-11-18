package section05;

import java.util.*;

/*
section: 05-04
title: 후위식 연산(postfix)
url: https://cote.inflearn.com/contest/10/problem/05-04
*/
public class Q04PostfixOperation {

    public int solution(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ((int) c >= 49 && (int) c <= 57) {
                stack.push(Integer.parseInt(String.valueOf(c)));
            } else {
                int x = stack.pop();
                int y = stack.pop();
                int temp = 0;

                switch (c) {
                    case '*':
                        temp = y * x;
                        break;
                    case '/':
                        temp = y / x;
                        break;
                    case '+':
                        temp = y + x;
                        break;
                    case '-':
                        temp = y - x;
                        break;
                }
                stack.push(temp);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Q04PostfixOperation t = new Q04PostfixOperation();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(t.solution(s));
        sc.close();
    }
}