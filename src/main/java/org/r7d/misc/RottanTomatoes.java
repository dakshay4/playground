package org.r7d.misc;

import java.util.LinkedList;
import java.util.Queue;

class RottanTomatoes {

    public static class Pair {
        private final int first;
        private final int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;

        }
    }

    public static void main(String[] args) {
        int grid[][] ={{1,2}};
        int grid1[][] ={{2,0,1,1,1,1,1,1,1,1},
                        {1,0,1,0,0,0,0,0,0,1},
                        {1,0,1,0,1,1,1,1,0,1},
                        {1,0,1,0,1,0,0,1,0,1},
                        {1,0,1,0,1,0,0,1,0,1},
                        {1,0,1,0,1,1,0,1,0,1},
                        {1,0,1,0,0,0,0,1,0,1},
                        {1,0,1,1,1,1,1,1,0,1},
                        {1,0,0,0,0,0,0,0,0,1},
                        {1,1,1,1,1,1,1,1,1,2}};
        orangesRotting(grid);
//        orangesRotting(grid1);
    }

    private static int[] dRow = {-1, 0, 1, 0};
    private static int[] dCol = {0, 1, 0, -1};
    public static int orangesRotting(int[][] grid) {

        boolean onlyRotten=false;
        boolean onlyFresh=false;
        for(int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) onlyFresh = true;
                if(grid[i][j]==2) onlyRotten = true;
            }
        }
        if(onlyRotten && !onlyFresh) return 0;
        if(onlyFresh && !onlyRotten) return -1;

        Pair p = new Pair(0,0);
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        int rottenMinutes = 0;
        for(int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==2) {
                    q.add(new Pair(i,j));
                    vis[i][j] = true;
                    rottenMinutes=-1;
                }
            }
        }
        while(!q.isEmpty()) {
            int size = q.size();
            rottenMinutes++;
            for(int i=0;i< size; i++) {
                RottanTomatoes.Pair pair = q.poll();
                int a = pair.first;
                int b = pair.second;
                for(int k=0;k<4;k++) {
                    int d6nRow = a+dRow[k];
                    int d6nCol = b+dCol[k];
                    if(isValid(vis, d6nRow, d6nCol) && grid[d6nRow][d6nCol]==1) {
                        grid[d6nRow][d6nCol]=2;
                    }
                    if(isValid(vis, d6nRow, d6nCol) && grid[d6nRow][d6nCol]==2) {
                        q.add(new Pair(d6nRow, d6nCol));
                        vis[d6nRow][d6nCol]=true;
                    }
                }
            }
        }
        System.out.println("RottanTomatoes" + rottenMinutes);
        for(int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
//                if(grid[i][j]==1) return -1;
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        return rottenMinutes;
    }

    public static boolean isRotten(int[][] grid, int d6nRow, int  d6nCol) {
        if(d6nRow < 0 || d6nCol < 0 || d6nRow>= grid.length || d6nCol>=grid[0].length) return false;
        return grid[d6nRow][d6nCol]==2;
    }

    public static boolean isFresh(int[][] grid, int d6nRow, int  d6nCol) {
        if(d6nRow < 0 || d6nCol < 0 || d6nRow>= grid.length || d6nCol>=grid[0].length) return false;
        return grid[d6nRow][d6nCol]==1;
    }

    public static boolean isEmpty(int[][] grid, int d6nRow, int d6nCol) {
        if(d6nRow <0 || d6nCol<0 || d6nRow>=grid.length || d6nCol>=grid[0].length) return true;
        return grid[d6nRow][d6nCol]==0;
    }

    public static boolean isValid(boolean[][] vis, int rowIndex, int colIndex) {
        if(rowIndex <0 || colIndex<0 || rowIndex>=vis.length || colIndex>=vis[0].length) return false;
        return !vis[rowIndex][colIndex];
    }

}

/*


2,1,1
0,1,0
1,0,1


1,2,1
0,1,0
1,0,1

2,2,2
0,2,0
1,0,1

2,2,2
0,2,0
1,0,1

2,2,2
0,2,0
1,0,1



*/