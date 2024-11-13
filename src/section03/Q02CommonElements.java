package section03;

import java.util.*;

/*
section: 03-02
title: 공통원소 구하기
[설명]
A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.

[입력]
첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
각 집합의 원소는 1,000,000,000이하의 자연수입니다.

[출력]
두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
*/
public class Q02CommonElements {

    public void solution(int[] arr, int[] arr2) {
        Arrays.sort(arr);
        Arrays.sort(arr2);
        List<Integer> list = new ArrayList<>();

        int idx1 = 0;
        int idx2 = 0;
        
        for (int i = 0; i < arr.length + arr2.length; i++) {
            if (idx1 >= arr.length)  {
                break;
            } else if (idx2 >= arr2.length) {
                break;
            } else {
                if (arr[idx1] == arr2[idx2]) {
                    list.add(arr[idx1]);
                    idx1++;
                    idx2++;
                } else {
                    if (arr[idx1] < arr2[idx2]) {
                        idx1++;
                    } else {
                        idx2++;
                    }
                }
            }
        }

        for (int n : list) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Q02CommonElements t = new Q02CommonElements();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        n = sc.nextInt();
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        t.solution(arr, arr2);
        sc.close();
    }
}
