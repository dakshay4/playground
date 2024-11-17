package org.r7d.misc;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TriangleRotate {

    public static void main(String[] args) {
        int[][] square = new int[10][10];
        for(int i=0;i<square.length;i++){
            for(int j=0;j<square[0].length;j++) {
                if(i==j && i>=3 && i<=6) square[i][j]=1;
                if(i>=3 && i<=6 && j==3) square[i][j]=1;
                if(j>=3 && j<=6 && i==6) square[i][j]=1;
            }
        }
        for(int i=0;i<square.length;i++){
            for(int j=0;j<square[0].length;j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }

    }
}



