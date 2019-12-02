package edu.unl.hcc.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.apache.avro.generic.GenericData;

/**
 * Given a set of distinct positive integers, find the largest subset such that every pair of
 * elements in the subset (i, j) satisfies either i % j = 0 or j % i = 0.
 *
 * <p>For example, given the set [3, 5, 10, 20, 21], you should return [5, 10, 20]. Given [1, 3, 6,
 * 24], return [1, 3, 6, 24].
 */
public class LargestModulableSubset {

    /**
    public static int[] findSubset(int[] array) {
        if(array==null||array.length<=1) return array;
        List<Integer> re = new ArrayList<>();
        HashSet<Integer> current = new HashSet();
        int largest;
        for(int i=0;i<array.length; i++) {
            largest=array[i];
            current.clear();
            current.add(array[i]);
            for(int j=i;j<array.length;j++) {
                if(current.contains(array[j])) {
                    continue;
                }
                if()
                if((i<j&&i%j==0)||(i>=j&&j%i==0)) {

                }
            }

        }

    }

    public static void main(String[] args) {
        int[] test1=new int[]{3,5,10,20,21};
        int[] test2=new int[]{1,3,6,24};
        System.out.println("result of test1 should be: " + findSubset(test1));
        System.out.println("result of test2 should be: " + findSubset(test2));
    }
     */
}
