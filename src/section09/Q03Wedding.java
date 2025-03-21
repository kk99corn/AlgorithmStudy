package section09;

import java.util.*;

/*
section: 09-03
title: 결혼식
*/
public class Q03Wedding {

    public static class Time implements Comparable<Time>{
        int t;
        int type;

        Time (int t, int type) {
            this.t = t;
            this.type = type;
        }

        @Override
        public int compareTo(Time o) {
            if (t == o.t) {
                return Integer.compare(type, o.type);
            }
            return Integer.compare(t, o.t);
        }

        @Override
        public String toString() {
            return "t: " + t + ", type: " + type;
        }
    }

    public int solution(int n, List<Time> timeList) {
        Collections.sort(timeList);

        int max = 0;
        int current = 0;
        for (Time t : timeList) {
            if (t.type == 1) {
                current++;
                max = Math.max(max, current);
            } else {
                current--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Q03Wedding t = new Q03Wedding();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Time> timeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            timeList.add(new Time(sc.nextInt(), 1));
            timeList.add(new Time(sc.nextInt(), 0));
        }

        sc.close();
        System.out.println(t.solution(n, timeList));
    }
}