package org.r7d.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Bfs2dArray {

    public static class Pair {
        private final int first;
        private final int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static int[] dRow = {-1,0,1,0};
    private static int[] dCol = {0,1,0,-1};

    public static void main(String[] args) {
        int grid[][] = {{2,0,1,1,1,1,1,1,1,1},
                        {1,0,1,0,0,0,0,0,0,1},
                        {1,0,1,0,1,1,1,1,0,1},
                        {1,0,1,0,1,0,0,1,0,1},
                        {1,0,1,0,1,0,0,1,0,1},
                        {1,0,1,0,1,1,0,1,0,1},
                        {1,0,1,0,0,0,0,1,0,1},
                        {1,0,1,1,1,1,1,1,0,1},
                        {1,0,0,0,0,0,0,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1}};

        // Declare the visited array
        boolean [][]vis = new boolean[grid.length][grid[0].length];

        BFS(grid, vis);
    }

    public static boolean isValid(boolean[][] vis, int rowIndex, int colIndex) {
        if(rowIndex <0 || colIndex<0 || rowIndex>=vis.length || colIndex>=vis[0].length) return false;
        return !vis[rowIndex][colIndex];
    }

    private static void BFS(int[][] grid, boolean[][] vis) {

        Bfs2dArray.Pair pair = new Pair(0,0);
        vis[0][0] = true;
        Queue<Bfs2dArray.Pair> q = new LinkedList<>();
        q.add(pair);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0; k<size; k++) {
                Bfs2dArray.Pair p = q.poll();
                int i = p.first;
                int j = p.second;
                System.out.print(grid[i][j]+" ");
                for(int d=0; d<4;d++){
                    if(isValid(vis, i+dRow[d], j+dCol[d])) {
                        q.add(new Pair(i+dRow[d], j+dCol[d]));
                        vis[i+dRow[d]][j+dCol[d]] = true;
                    }
                }
            }
        }
    }


}
