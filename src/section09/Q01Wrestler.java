package section09;

import java.util.*;

/*
section: 09-01
title: 씨름 선수
*/
public class Q01Wrestler {

    public static class Body implements Comparable<Body> {
        int height;
        int weight;

        public Body(int h, int w) {
            height = h;
            weight = w;
        }

        @Override
        public int compareTo(Body o) {
            return Integer.compare(o.height, height);
        }

        @Override
        public String toString() {
            return "h: " + height + ", w: " + weight;
        }
    }

    public int getAvailableCount(int n, Body[] body) {
        int answer = 0;
        Arrays.sort(body);

        int maxWeight = -1;
        for (int i = 0; i < n; i++) {
            if (maxWeight < body[i].weight) {
                maxWeight = body[i].weight;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Q01Wrestler t = new Q01Wrestler();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Body[] body = new Body[n];

        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();

            body[i] = new Body(h, w);
        }

        sc.close();

        System.out.println(t.getAvailableCount(n, body));
    }
}