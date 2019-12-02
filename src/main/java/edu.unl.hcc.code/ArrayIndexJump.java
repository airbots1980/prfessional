package edu.unl.hcc.code;

import java.util.HashMap;

/**
 * You are given an array of non-negative integers. Let's say you start at the beginning of the array
 * and are trying to advance to the end. You can advance at most, the number of steps that you're
 * currently on. Determine whether you can get to the end of the array.
 *
 * <p>For example, given the array [1, 3, 1, 2, 0, 1], we can go from indices 0 -> 1 -> 3 -> 5, so
 * return true.
 *
 * <p>Given the array [1, 2, 1, 0, 0], we can't reach the end, so return false.
 */

public class ArrayIndexJump {

    static HashMap<Integer, Boolean> cache = new HashMap();

    public static boolean toEnd(int[] array) {
        if(array == null || array.length == 0) return false;
        return dfs(array, 0);
    }

    private static boolean dfs(int[] array, int idx) {
        if(idx > array.length-1) return false;
        int len = array.length;
        int count = array[idx];
        boolean result = false;
        if(count >= len-idx-1 ) return true;
        if(count == 0 && idx!=len-1) {
            cache.put(idx, false);
            return false;
        }

        for(int i=1;i<=count;i++) {
            if(cache.containsKey(idx+i)) {
                continue;
            } else {
                result = result || dfs(array, idx + i);
            }
        }
        cache.put(idx, result);
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1, 3, 1, 2, 0, 1};
        int[] test2 = new int[]{1, 2, 1, 0, 0};

        System.out.println("Test1 result should be true: " + toEnd(test1));
        System.out.println("Test2 result should be false: " + toEnd(test2));

    }
}
