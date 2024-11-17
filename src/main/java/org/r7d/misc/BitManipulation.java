package org.r7d.misc;

public class BitManipulation {

    public static String bin(int m) {
        String s = "";
        while(m>0){
            s = m % 2 + s;
            m = m/2;
        }
        return s;
    }

    public static int find(int m, int n, int index) {
        String bin = bin(m);
        for(int j=0;j<n;j++) {
            StringBuilder res = new StringBuilder();
            for(int k = 0; k< bin.length(); k++) {
                if(bin.charAt(k)=='0') res.append("01");
                else if(bin.charAt(k)=='1') res.append("10");
            }
            bin = res.toString();
        }
        return bin.charAt(index) - '0';
    }
    public static void main(String[] args) {
        int a = 5;

    }
}

//8421
//0101
/*
01100110
0110100101101001
*/