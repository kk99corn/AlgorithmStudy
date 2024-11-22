package section05;

import java.util.*;

/*
section: 05-08
title: 응급실
url: https://cote.inflearn.com/contest/10/problem/05-08
*/
public class Q08Emergency {

    public class Patient {
        private int risk;
        private int order;

        public int getOrder() {
            return this.order;
        }

        public int getRisk() {
            return this.risk;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public void setRisk(int risk) {
            this.risk = risk;
        }

        public Patient(int risk, int order) {
            this.risk = risk;
            this.order = order;
        }
    }

    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        Queue<Patient> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            q.add(new Patient(arr[i], i));
        }

        while (!q.isEmpty()) {
            Patient patient = q.poll();

            boolean isRiskFlag = true;
            for (Patient p : q) {
                if (patient.getRisk() < p.getRisk()) {
                    isRiskFlag = false;
                    break;
                }
            }

            if (isRiskFlag) {
                answer++;
                if (patient.getOrder() == k) {
                    break;
                }
            } else {
                q.add(patient);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Q08Emergency t = new Q08Emergency();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(t.solution(n, k, arr));
        sc.close();
    }
}