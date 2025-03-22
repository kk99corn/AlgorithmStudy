package section10;

import java.util.*;

/*
section: 10-05
title: 동전교환
3
1 2 5
15
*/

public class Q05Coin {

    public int getMax(int[] coin, int m) {
        int[] price = new int[m + 1];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[0] = 0;

        for (int i = 0; i < coin.length; i++) {
            int c = coin[i];
            for (int j = c; j < price.length; j++) {
                if (price[j] > price[j - c]  + 1) {
                    price[j] = price[j - c]  + 1;
                }
            }
        }

        return price[m];
    }

    public static void main(String[] args) {
        Q05Coin t = new Q05Coin();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        sc.close();

        System.out.println(t.getMax(coin, m));
    }
}