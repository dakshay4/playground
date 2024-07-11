package org.r7d.misc;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] a = new String[]{
                "opre", "preheat", "prehistoric"
        };
        Arrays.sort(a);
        for (String s : a) {
            System.out.println(s);
        }
        System.out.println(longestCommonPrefix(a));
    }

    public static String longestCommonPrefix(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
