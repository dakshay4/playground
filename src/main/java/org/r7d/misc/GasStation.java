package org.r7d.misc;

import java.util.*;

class GasStation {

    public static String ArrayChallenge(String[] strArr) {
        // code goes here
        int i = 1;
        int j = 1;
        int size = strArr.length;
        String result = "impossible";
        while(i < size ){
            int gallonsStorage = 0;
            int endpoint = size; int stationsTraversed = 0;
            int rotate = j;
            while(rotate<endpoint) {
                String element  = strArr[rotate];
                String[] station = element.split("\\:");
                int gallons = Integer.parseInt(station[0]);
                int spend = Integer.parseInt(station[1]);
                gallonsStorage +=gallons;
                if(gallonsStorage < spend) break;
                gallonsStorage-=spend;
                if(rotate == size-1) {
                    rotate=1; endpoint = i;
                } else rotate++;
                stationsTraversed++;
            }
            if(gallonsStorage>=0 && stationsTraversed==size-1) return String.valueOf(i);
            i++;j++;
        }
        return result;
    }

    public static void main (String[] args) {
        // keep this function call here
        System.out.println(ArrayChallenge(new String[]{"4","2:3","2:1","1:2","0:1"}));
    }

}

// ["4","3:1","2:2","1:2","0:1"]