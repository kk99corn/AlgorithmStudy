package section06;

import java.util.*;

/*
section: 06-09
title: 뮤직비디오(결정 알고리즘)
url: https://cote.inflearn.com/contest/10/problem/06-09
*/
public class Q09MusicVideo {

    public int discCount(int[] arr, int cap) {
        int count = 1;
        int sum = 0;
        for (int n : arr) {
            sum += n;
            if (sum > cap) {
                sum = n;
                count++;
            }
        }
        return count;
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;

        int lt = 0;
        int rt = 0;

        for (int i : arr) {
            if (lt < i) {
                lt = i;
            }
            rt += i;
        }

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (discCount(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Q09MusicVideo t = new Q09MusicVideo();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(t.solution(n, m, arr));
        sc.close();
    }
}