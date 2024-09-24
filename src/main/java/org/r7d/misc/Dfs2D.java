package org.r7d.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Dfs2D {

    static class Pair {
        private final int x;
        private final int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    private static int[] dRow = {0, 1, 0, -1};
    private static int[] dCol = {-1, 0, 1,0};

    public static List<Integer> dfs(int[][] grid, boolean[][] vis, int row, int col) {

        Pair pair = new Pair(row,col);
        Stack<Pair> st = new Stack<>();
        st.add(pair);

        List<Integer> res = new ArrayList<>();
        while(!st.empty()){
            Pair p = st.pop();
            int r = p.x;
            int c = p.y;
            if(isValidIndex(p, vis)){
                res.add(grid[r][c]);
                vis[r][c] = true;
                for(int i=0;i<4;i++) {
                    st.push(new Pair(r+dRow[i],c+dCol[i] ));
                }
            }
        }
        return res;
    }

    private static boolean isValidIndex(Pair p, boolean[][] vis) {
        int x = p.x;
        int y = p.y;
        int row = vis.length;
        int col = vis[0].length;
        if(x<0 || x>=row || y<0 || y>=col) return false;
        return !vis[x][y];
    }

    public static void main(String[] args) {
        int grid[][] = { { -1, 2, 3 },
                { 0, 9, 8 },
                { 1, 0, 1 } };
        int row = grid.length;
        int col = grid[0].length;
        boolean vis[][] = new boolean[row][col];
        for(int i=0;i<row;i++) for (int j=0; j<col; j++) vis[i][j] = false;
        List<Integer> res = dfs(grid, vis, 0,0);
        res.forEach(e-> System.out.print(e + " "));
    }
}
