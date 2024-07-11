package org.r7d.misc;

import java.util.Arrays;

public class FirstUniqueCharacter {


    public static void main(String[] args) {
        System.out.println("Minindex : " + firstUniqChar("leetcode"));
        System.out.println("Minindex : " + firstUniqChar("loveleetcode"));
        System.out.println("Minindex : " + firstUniqChar("aabb"));
        System.out.println("Minindex : " + firstUniqChar("a"));
        System.out.println("Minindex : " + firstUniqChar("aadadaad"));
    }

    public static int firstUniqChar(String s) {
        int[] p = new int[26];
        Arrays.fill(p,-1);
        int minIndex = Integer.MAX_VALUE;
        for(int i=0; i<s.length() ; i++) {
            int ascii = s.charAt(i)-97;
            if(p[ascii]==-1) p[ascii] = i;
            else p[ascii]=Integer.MAX_VALUE;
        }
        for (int i : p) {
//            System.out.println(i);
            if(i>=0) minIndex = Math.min(minIndex, i);
        }
        return minIndex==Integer.MAX_VALUE ? -1 : minIndex;
    }
}
