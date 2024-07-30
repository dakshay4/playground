package org.r7d.misc;

public class ClimbingDP2 {

    public static void main(String[] args) {
        minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1});
        //                              0  1  2 3 4  5  6 7  8  9
    }

    static int[] step;
    public static int minCostClimbingStairs(int[] cost) {
        step = new int[cost.length+1];for(int i=0;i<=cost.length;i++) step[i]=-1;
        return Math.min(dp(cost, cost.length-1),dp(cost, cost.length-2));
    }

    public  static  int dp(int[]cost, int end) {
        if(end<0) return 0;
        if(step[end]!=-1) return step[end];
        int costAtStep = cost[end]+ Math.min(dp(cost,end-1),
                dp(cost,end-2));
        step[end] = costAtStep;
        System.out.println("Step [" + end + "]: "+ step[end]);
        return step[end];
    }
}
