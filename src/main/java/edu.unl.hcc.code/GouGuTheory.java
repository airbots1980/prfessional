package edu.unl.hcc.code;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, determine whether it contains a Pythagorean
 * triplet. Recall that a Pythogorean triplet (a, b, c) is defined by the
 * equation a2+ b2= c2.
 */
public class GouGuTheory {

    public static boolean exists(int[] array) {
        if (array == null||array.length<=2) return false;
        HashSet<Long> pool = new HashSet();
        for(int i: array) {
            if(i>0) pool.add((long) (i*i));
        }
        for(long can: pool) {
            if(threeSum(pool, can)) return true;
        }
        return false;
    }

    private static boolean threeSum(Set<Long> candidates, long target) {
        for(long can: candidates) {
            if(candidates.contains(Math.abs(can - target))) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{3,4,5,1,100,200};
        int[] test2 = new int[]{1,2,4};
        System.out.println(exists(test1));
        System.out.println(exists(test2));
    }
}
