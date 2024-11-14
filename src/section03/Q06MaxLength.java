package section03;

import java.util.*;

/*
section: 03-06
title: 최대 길이 연속부분수열

[설명]
0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
1 1 0 0 1 1 0 1 1 0 1 1 0 1
여러분이 만들 수 있는 1이 연속된 연속부분수열은
이며 그 길이는 8입니다.

[입력]
첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.

[출력]
첫 줄에 최대 길이를 출력하세요.
*/
public class Q06MaxLength {

    public int solution(int n, int k, int[] arr) {
        int max = 0;
        int sum = 0;
        int l = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            int temp = arr[r];

            if (temp == 0) {
                q.add(r);
                temp = 1;
            }

            sum += temp;
            if (q.size() > k) {
                int temp2 = q.poll() + 1;
                sum -= (temp2 - l);
                l = temp2;
            }

            System.out.println(sum + " " + q.toString());

            if (max < sum)
                max = sum;
        }

        return max;
    }

    public int gptSolution(int n, int k, int[] arr) {
        int max = 0; // 최대 길이를 저장할 변수
        int l = 0; // 왼쪽 포인터
        int zeroCount = 0; // 현재 포함된 '0'의 수

        // 슬라이딩 윈도우 방식 사용
        for (int r = 0; r < n; r++) {
            // 오른쪽 포인터를 이동하면서 '0'을 만나면 카운트 증가
            if (arr[r] == 0) {
                zeroCount++;
            }

            // '0'의 개수가 k를 초과하면 왼쪽 포인터 이동
            while (zeroCount > k) {
                if (arr[l] == 0) {
                    zeroCount--;
                }
                l++;
            }

            // 현재 윈도우의 길이와 최대 길이를 비교하여 갱신
            max = Math.max(max, r - l + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        Q06MaxLength t = new Q06MaxLength();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(t.solution(n, k, arr));
        System.out.println(t.gptSolution(n, k, arr));
        sc.close();
    }
}