package section01;

import java.util.*;

/*
section: 01-10
title: 가장 짧은 문자거리
[설명]
한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

[입력]
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
문자열의 길이는 100을 넘지 않는다.

[출력]
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
*/
public class Q10ShortestDistance {

    public String solution(String str, char c) {
        String answer = "";
        List<Integer> idxList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) idxList.add(i);
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                answer += "0";
            } else {
                int minDis = Integer.MAX_VALUE;
                for (int j = 0; j < idxList.size(); j++) {
                    int dis = Math.abs(i - idxList.get(j));
                    if (minDis > dis) minDis = dis;
                }
                answer += minDis;
            }

            if (i != str.length() - 1) answer += " ";
        }

        return answer;
    }

    public String stdSolution(String str, char c) {
        String answer = "";
        int[] distanceArr = new int[str.length()];

        int dis = str.length();
        for (int i = 0; i < str.length(); i++) {
            dis = str.charAt(i) == c ? 0 : dis + 1;
            distanceArr[i] = dis;
        }
 
        dis = str.length();
        for (int i = str.length() - 1; i >= 0; i--) {
            dis = str.charAt(i) == c ? 0 : dis + 1;
            if (distanceArr[i] > dis) {
                distanceArr[i] = dis;
            }
        }

        for (int a : distanceArr) {
            answer += a + " ";
        }

        return answer;
    }

    public static void main(String[] args) {
        Q10ShortestDistance t = new Q10ShortestDistance();
        Scanner sc = new Scanner(System.in);
        // teachermode e
        String str = sc.next();
        String c = sc.next();
        System.out.println(t.solution(str, c.charAt(0)));
        System.out.println(t.stdSolution(str, c.charAt(0)));
        sc.close();
    }
}
