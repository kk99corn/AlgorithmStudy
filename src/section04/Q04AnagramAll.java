package section04;

import java.util.*;

/*
section: 04-04
title: 모든 아나그램 찾기

[설명]
S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.

[입력]
첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.

[출력]
S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
*/
public class Q04AnagramAll {

    public String sortedString(String s) {
        char[] tmpArr = s.toCharArray();
        Arrays.sort(tmpArr);
        
        String anagram = "";
        for (char c : tmpArr) {
            anagram += c;
        }


        return anagram;
    }

    public int solution(String str1, String str2) {
        int answer = 0;
        int size = str2.length();
        String tmp = "";

        str2 = sortedString(str2);
        for (int i = 0; i < str1.length(); i++) {
            tmp += str1.charAt(i);
            if (i >= size - 1) {
                if (str2.equals(sortedString(tmp))) {
                    answer++;
                }
                tmp = tmp.substring(1, tmp.length());
            }
        }

        return answer;
    }

    public int stdSolution(String str1, String str2) {
        int answer = 0;
        Map<Character, Integer> anagram = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str2.length(); i++) {
            anagram.put(str2.charAt(i), anagram.getOrDefault(str2.charAt(i), 0) + 1);
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
        }

        if (anagram.equals(map)) answer++;

        int l = 0;
        for (int i = str2.length(); i < str1.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
            map.put(str1.charAt(l), map.get(str1.charAt(l)) - 1);
            if (map.get(str1.charAt(l)) == 0) map.remove(str1.charAt(l));
            if (anagram.equals(map)) answer++;
            l++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Q04AnagramAll t = new Q04AnagramAll();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(t.solution(str1, str2));
        System.out.println(t.stdSolution(str1, str2));
        sc.close();
    }
}