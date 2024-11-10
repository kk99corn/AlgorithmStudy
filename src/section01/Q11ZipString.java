package section01;

import java.util.*;

/*
section: 01-11
title: 문자열 압축
[설명]
알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
단 반복횟수가 1인 경우 생략합니다.

[입력]
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

[출력]
첫 줄에 압축된 문자열을 출력한다.
*/
public class Q11ZipString {

    public String solution(String str) {
        String answer = "";
        char temp = '0';
        int idx = 0;
        int cnt = 1;
        List<String> strList = new ArrayList<>();
        for (char c : str.toCharArray()) {

            if (temp == c) {
                cnt++;
                strList.set(idx-1, c + "" + cnt);
            } else {
                temp = c;
                cnt = 1;
                strList.add(Character.toString(c));
                idx++;
            }
        }
        
        for (String s : strList) {
            answer += s;
        }

        return answer;
    }

    public String stdSolution(String str) {
        String answer = "";
        char[] charArr = str.toCharArray();

        int cnt = 1;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr.length - 1 > i + 1 && charArr[i] == charArr[i + 1]) {
                cnt++;
            } else {
                answer += charArr[i] + "" + (cnt > 1 ? cnt : "");
                cnt = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Q11ZipString t = new Q11ZipString();
        Scanner sc = new Scanner(System.in);
        // KKHSSSSSSSE
        String str = sc.next();
        System.out.println(t.solution(str));
        System.out.println(t.stdSolution(str));
        sc.close();
    }
}
