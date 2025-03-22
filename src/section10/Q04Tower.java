package section10;

import java.util.*;

/*
section: 10-04
title: 가장 높은 탑 쌓기
5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2
*/


class Brick implements Comparable<Brick>{
    int s;
    int h;
    int w;

    Brick (int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o) {
        return Integer.compare(o.s, s);
    }
}
public class Q04Tower {

    public int getMax(int n, List<Brick> brickList) {
        int answer = 0;
        Collections.sort(brickList);

        int[] dp = new int[n];
        dp[0] = brickList.get(0).h;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (brickList.get(j).w > brickList.get(i).w) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + brickList.get(i).h;
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Q04Tower t = new Q04Tower();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Brick> brickList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            brickList.add(new Brick(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        sc.close();

        System.out.println(t.getMax(n, brickList));
    }
}