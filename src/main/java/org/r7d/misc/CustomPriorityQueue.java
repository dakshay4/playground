package org.r7d.misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CustomPriorityQueue {

    public static boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt((int[] a) -> a[1]));
        PriorityQueue<Direction> pq = new PriorityQueue<Direction>(Comparator.comparingInt(Direction::getTo));
        int capacityNeed = 0;
        for(int[] trip : trips) {
            int cap = trip[0];
            int from = trip[1];
            while(!pq.isEmpty()) {
                if(pq.peek().getTo() <= from) capacityNeed-=pq.poll().getCapacity();
                else break;
            }
            capacityNeed+=cap;

            pq.add(new Direction(trip[0], trip[1], trip[2]));


        }

        return capacityNeed <= capacity;
    }

    public static void main(String[] args) {

        int[][] trips = {{2,1,10},{4,6,9},{1,2,6}};
        int[][] trips1 = {{2,1,5},{4,5,7}};
        int[][] trips2 = {{2,1,5}};
        int[][] trips3 = {{5,1,5}};
        int[][] trips4 = {{2,1,5},{3,2,5}};
        System.out.println("car pool done: " + carPooling(trips, 4));
        System.out.println("car pool done: " + carPooling(trips1, 4));
        System.out.println("car pool done: " + carPooling(trips2, 4));
        System.out.println("car pool done: " + carPooling(trips3, 4));

    }
}
