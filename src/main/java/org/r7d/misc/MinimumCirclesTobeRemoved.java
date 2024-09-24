package org.r7d.misc;

import java.util.*;

public class MinimumCirclesTobeRemoved {

    public static class Circle implements Comparator<Circle> {
        private int start;
        private int end;

        @Override
        public int compare(Circle o1, Circle o2) {
            return o1.end==o2.end ? o1.start - o2.start : o1.end - o2.end;
        }
    }
    public static void main(String[] args)
    {
        MinimumCirclesTobeRemoved a = new MinimumCirclesTobeRemoved();

        // centers of circles
        int[] c = new int[]{1, 2, 3, 4};

        // radius of circles
        int[] r = new int[]{1, 1, 1, 1};
        System.out.println("Overlaps are: " +a.CountCircles(c, r, c.length));
    }

    private int CountCircles(int[] c, int[] r, int length) {

        List<Circle> circles = new ArrayList<>();
        for(int i=0;i< length; i++) {
            Circle circle = new Circle();
            circle.start = c[i] - r[i];
            circle.end = c[i] + r[i];
            circles.add(circle);
        }
        circles.sort((o1, o2) -> o1.end == o2.end ? o1.start - o2.start : o1.end - o2.end);

        Circle firstCircle = circles.get(0);
        int overlap = 0;
        for(int i=1; i<circles.size();i++) {
            if(firstCircle.end>circles.get(i).start) overlap++;
            else firstCircle = circles.get(i);
        }
        return overlap;
    }
}
