package edu.unl.hcc.leetcode.microsoft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of positive integers, divide the array into two
 * subsets such that the difference between the sum of the subsets is as small as possible.
 *
 * For example, given [5, 10, 15, 20, 25], return the sets {10, 25}
 * and {5, 15, 20}, which has a difference of 5, which is the smallest possible difference.
 */
public class MinSubsetDiff {

    public static int findSmallestDiff(int[] array) {
        if(array==null||array.length==0) return 0;
        int[] dp =new int[array.length];
        Arrays.sort(array);
        dp[array.length-1]=Math.abs(array[array.length-1]-array[array.length-2]);
        System.out.printf("Current i is %d and dp[i] is %d \n", array.length,dp[array.length-1]);
        for(int i=array.length-3;i>=0;i--) {
            if(dp[i+1]>0) {
                dp[i]=dp[i+1]-array[i];
            } else {
                dp[i]=dp[i+1]+array[i];
            }
            System.out.printf("Current i is %d and dp[i] is %d \n", i, dp[i]);
        }
        return Math.abs(dp[0]);
    }

    public static void main(String[] args){
        int[] test1 = new int[]{5,10,15,20,25};
        int[] test2 = new int[]{5, 1000, 80, 39, 999};
        System.out.println("Minimum difference is: "+findSmallestDiff(test1));
        System.out.println("Minimum difference is: "+findSmallestDiff(test2));
    }
}
