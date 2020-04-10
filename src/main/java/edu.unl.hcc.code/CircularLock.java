package edu.unl.hcc.leetcode.citrix;

import edu.unl.hcc.service.common.StringUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *You are given a circular lock with three wheels, each of which display
 *  the numbers 0 through 9 in order. Each of these wheels rotate clockwise
 *  and counterclockwise.
 *
 * In addition, the lock has a certain number of "dead ends", meaning that
 * if you turn the wheels to one of these combinations, the lock becomes
 * stuck in that state and cannot be opened.
 *
 * Let us consider a "move" to be a rotation of a single wheel by one digit,
 * in either direction. Given a lock initially set to 000, a target
 * combination, and a list of dead ends, write a function that returns
 * the minimum number of moves required to reach the target state, or
 * None if this is impossible.
 */

public class CircularLock {

    public static int findMinStep(String target, Set<String> deadlocks) {
        //boundary conditions
        if(StringUtils.isEmpty(target)|| target.equals("000")) return 0;
        else if(deadlocks.contains(target)||deadlocks.contains("000")) return -1;
        Queue<String> q = new LinkedList();
        q.add("000");
        int count = 0;
        while(!q.isEmpty()) {
            String current = q.poll();

            if(current.equals(target)) return count;
        }

        return -1;
    }

    public static void main(String[] args) {
        char[] a = "000".toCharArray();
        HashSet<String> de = new HashSet(Arrays.asList("100","090","900"));
        System.out.println("Result is: " + findMinStep("010",de));
    }
}
