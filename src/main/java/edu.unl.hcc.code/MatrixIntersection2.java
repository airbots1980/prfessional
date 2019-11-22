package edu.unl.hcc.code;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * You are given given a list of rectangles represented by min and max
 * x- and y-coordinates. Compute whether or not a pair of rectangles
 * overlap each other. If one rectangle completely covers another,
 * it is considered overlapping.
 *
 * For example, given the following rectangles:
 *
 * {
 *     "top_left": (1, 4),
 *     "dimensions": (3, 3) # width, height
 * },
 * {
 *     "top_left": (-1, 3),
 *     "dimensions": (2, 1)
 * },
 * {
 *     "top_left": (0, 5),
 *     "dimensions": (4, 3)
 * }
 */
public class MatrixIntersection2 {

    public MatrixIntersection2() {};

    public static boolean verify(int[][] mstrix, List<List<Integer>> rects) {
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> rects = new ArrayList();
        List<Integer> r1 = Arrays.asList(1,4,3,3);
        List<Integer> r2 = Arrays.asList(-1,3,2,1);
        List<Integer> r3 = Arrays.asList(0,5,4,3);
    }
}
