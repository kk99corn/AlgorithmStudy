package section05;

import java.util.*;

/*
section: 05-07
title: 교육과정 설계
url: https://cote.inflearn.com/contest/10/problem/05-07
*/
public class Q07Subject {

    public String solution(String s, String s2) {
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            q.offer(c);
        }

        for (char c : s2.toCharArray()) {
            if (c == q.peek()) {
                q.poll();
                if (q.isEmpty()) break;
            }
        }

        return q.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Q07Subject t = new Q07Subject();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String s2 = sc.next();

        System.out.println(t.solution(s, s2));
        sc.close();
    }
}