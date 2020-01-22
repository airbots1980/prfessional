/**
 * You are given an array of integers, where each element represents the
 * maximum number of steps that can be jumped going forward from that element.
 * Write a function to return the minimum number of jumps you must take in order
 * to get from the start to the end of the array.
 *
 * For example, given [6, 2, 4, 0, 5, 1, 1, 4, 2, 9], you should return 2, as
 * the optimal solution involves jumping from 6 to 5, and then from 5 to 9.
 */

public class MinStepJumpToEnd {

    public static int findMinJump(int[] array) {
        if(array==null||array.length==0) return -1;
        int result = 0;
        int[] dp = new int[array.length];
        for(int i=dp.length-1;i>=0;i--){
            if(i==dp.length-1) dp[i]=0;
            dp[i]=findMin(dp,array[i], i);
        }
        return dp[0];
    }

    private static int findMin(int[] dp, int val, int idx) {
        int min=Integer.MAX_VALUE/2;
        if(val>=dp.length-idx-1) return 1;
        else {
            for(int i=idx+1;i<=val+idx&&i<dp.length;i++) {
                if(dp[i]<min) min = dp[i];
            }
        }
        return min+1;
    }
    public static void main(String[] args) {
        int[] test1= new int[]{6,2,4,0,5,1,1,4,2,9};
        int[] test2= new int[]{7,6,5,4,3,2,1};
        int[] test3= new int[]{1,1,1,1,1,1,1};

        //System.out.println("Greedy test1 result is: " + findMinJump2(test1));
        //System.out.println("Greedy test2 result is: " + findMinJump2(test2));
        //System.out.println("Greedy test3 result is: " + findMinJump2(test3));

        System.out.println("DP test1 result is: " + findMinJump(test1));
        System.out.println("DP test2 result is: " + findMinJump(test2));
        System.out.println("DP test3 result is: " + findMinJump(test3));
    }
}