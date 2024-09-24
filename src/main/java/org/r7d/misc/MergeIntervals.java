package org.r7d.misc;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int a1 = a[0];
            int b1 = b[0];

            return Integer.compare(a1, b1);
        });
        return intervals;
    }
}
