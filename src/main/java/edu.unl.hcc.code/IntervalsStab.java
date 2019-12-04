package edu.unl.hcc.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Let X be a set of n intervals on the real line. We say that
 * a set of points P "stabs" X if every interval in X contains
 * at least one point in P. Compute the smallest set of points that stabs X.
 *
 * For example, given the intervals [(1, 4), (4, 5), (7, 9),
 * (9, 12)], you should return [4, 9].
 */
public class IntervalsStab {

    public static List<Integer> findStab(List<List<Integer>> intervals) {
        if(intervals==null||intervals.size()==0) return null;
        else if(intervals.size()==1) return intervals.get(0);
        List<Integer> result = new LinkedList();
        Collections.sort(intervals,
            Comparator.comparingInt(integers -> integers.get(0)));
        int lower = intervals.get(0).get(1);
        int upper = intervals.get(intervals.size()-1).get(0);
        for(List<Integer> interval: intervals){
            lower = interval.get(1)<lower?interval.get(1):lower;
        }
        result.add(lower);
        result.add(upper);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> test1 = new LinkedList();
        test1.add(Arrays.asList(1,4));
        test1.add(Arrays.asList(2,3));
        test1.add(Arrays.asList(4,5));
        test1.add(Arrays.asList(7,9));
        test1.add(Arrays.asList(9, 12));
        test1.add(Arrays.asList(10,11));
        System.out.println("Stab of test1 is: "+findStab(test1));
    }
}
