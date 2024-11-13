package section03;

import java.util.*;

/*
section: 03-01
title: 두 배열 합치기
[설명]
오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.

[입력]
첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

[출력]
오름차순으로 정렬된 배열을 출력합니다.
*/
public class Q01SumArray {

    public void solution(int[] arr, int[] arr2) {
        int n = arr.length + arr2.length;
        int[] result = new int[n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (i == arr.length) {
                idx = 0;
            }

            result[i] = (i < arr.length) ? arr[idx] : arr2[idx];
            idx++;
        }

        Arrays.sort(result);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public void stdSolution(int[] arr, int[] arr2) {
        int n = arr.length + arr2.length;
        int[] result = new int[n];

        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < n; i++) {
            boolean isFlag = true;

            if (idx1 >= arr.length)  {
                isFlag = false;
            } else if (idx2 >= arr2.length) {
                isFlag = true;
            } else {
                if (arr[idx1] < arr2[idx2]) {
                    isFlag = true;
                } else {
                    isFlag = false;
                }
            }

            if (isFlag) {
                result[i] = arr[idx1];
                idx1++;
            } else {
                result[i] = arr2[idx2];
                idx2++;
            }
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
        
    }

    public static void main(String[] args) {
        Q01SumArray t = new Q01SumArray();
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
        System.out.println();
        t.stdSolution(arr, arr2);
        sc.close();
    }
}
