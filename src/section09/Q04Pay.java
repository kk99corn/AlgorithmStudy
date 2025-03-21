package section09;

import java.util.*;

/*
section: 09-04
title: 최대 수입 스케쥴
*/
public class Q04Pay {

    public static class Schedule implements Comparable<Schedule> {
        int pay;
        int time;

        Schedule(int pay, int time) {
            this.pay = pay;
            this.time = time;
        }

        @Override
        public int compareTo(Schedule o) {
            return Integer.compare(o.time, time);
        }

        @Override
        public String toString() {
            return "pay: " + pay + ", time: " + time;
        }
    }

    public int solution(int maxTime, List<Schedule> scheduleList) {
        int max = 0;
        Collections.sort(scheduleList);


        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        for (int i = maxTime; i > 0; i--) {
            for (int j = idx; j < scheduleList.size(); j++) {
                Schedule s = scheduleList.get(j);
                if (i == s.time) {
                    q.offer(s.pay);
                } else {
                    idx = j;
                    break;
                }
            }
            
            if (!q.isEmpty()) {
                // System.out.println(q);
                int currentPay = q.poll();
                // System.out.println("pay: " + currentPay);
                max += currentPay;
            }
            System.out.println();
        }

        return max;
    }

    public static void main(String[] args) {
        Q04Pay t = new Q04Pay();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxTime = 0;
        List<Schedule> scheduleList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int time = sc.nextInt();
            scheduleList.add(new Schedule(p, time));
            maxTime = Math.max(maxTime, time);
        }
        sc.close();
        System.out.println(t.solution(maxTime, scheduleList));
    }
}