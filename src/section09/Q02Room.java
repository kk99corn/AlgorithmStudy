package section09;

import java.util.*;

/*
section: 09-02
title: 회의실 배정
*/
public class Q02Room {

    public static class Room implements Comparable<Room> {
        int s;
        int e;

        Room (int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Room o) {
            if (e == o.e) {
                return Integer.compare(s, o.s);
            }
            return Integer.compare(e, o.e);
        }
    }

    public static void main(String[] args) {
        Q02Room t = new Q02Room();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> roomList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            roomList.add(new Room(sc.nextInt(), sc.nextInt()));
        }

        sc.close();

        Collections.sort(roomList);
        int answer = 0;
        int end = -1;
        for (Room r : roomList) {
            if (end <= r.s) {
                end = r.e;
                answer++;
            }
        }

        System.out.println(answer);
    }
}