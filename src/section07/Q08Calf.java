package section07;

import java.util.*;

/*
section: 07-08
title: 송아지 찾기 1(BFS)
*/
public class Q08Calf {

    int answer = 0;
    int[] dis = { 1, -1, 5 };
    int[] check;
    Queue<Integer> q = new LinkedList<>();

    public int solution(int s, int e) {
        check = new int[10001];
        check[s] = 1;
        q.offer(s);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int x = q.poll();
                if (x == e) {
                    return level;
                }
                for (int k : dis) {
                    if (x + k == e)
                        return level + 1;
                    if (x + k > 0 && x + k <= 10000 && check[x + k] == 0) {
                        check[x + k] = 1;
                        q.offer(x + k);
                    }
                }
            }
            level++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Q08Calf t = new Q08Calf();

        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();

        System.out.println(t.solution(s, e));
        sc.close();
    }
}