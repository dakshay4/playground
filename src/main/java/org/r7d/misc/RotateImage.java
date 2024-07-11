package org.r7d.misc;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        printMatrix(matrix);
        int[] p = new int[26];

    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int left = 0;
        int right = n-1;
        while(left<=right){
            for(int i=0; i<n;i++) {
                swap(matrix, i, left, i, right);
            }
            left++;right--;
        }
        left = 0;
        while(left<n) {
            right = n-left- 1;
            for (int i = 0; i < n; i++) {
                if(left == (n-i-1) && i == right) break;
                System.out.println("[" + left + "," + i+ "]   <->  [" + (n-i-1) + "," + right + "]"  );
//                swap(matrix, left, i, n -i - 1, right);
            }
            left++;
        }
    }

    public static void swap(int[][] matrix, int i, int left, int j, int right) {
        int temp = matrix[i][left];
        matrix[i][left] = matrix[j][right];
        matrix[j][right] = temp;
    }
}
