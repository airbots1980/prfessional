package edu.unl.hcc.code;

import java.util.Arrays;

/**
 * An imminent hurricane threatens the coastal town of Codeville.
 * If at most two people can fit in a rescue boat, and the maximum
 * weight limit for a given boat is k, determine how many boats will
 * be needed to save everyone.
 *
 * For example, given a population with weights [100, 200, 150, 80]
 * and a boat limit of 200, the smallest number of boats required will be three.
 */

public class NumBoatToRescuePeople {

    int BOAT_WEIGHT_LIMIT = 200;

    public static int computeBoat(int[] weight) {
        //boundary conditions
        if(weight==null||weight.length==0) return 0;
        int result = 0;
        Arrays.sort(weight);
        int pleft = 0;
        int pright = weight.length-1;
        System.out.println("pright: "+ pright);
        //carry 是用来保留之前做且小于200的和
        int carry=0;
        while(pleft<=pright && pright >=0) {
            int sum = weight[pleft] + weight[pright] + carry;
            //initial position
            if(pleft==0&&pright==weight.length-1) {
                if(weight[pright]>200) return 0;
                if(sum > 200) {
                    result++;
                    pright--;
                    carry=0;
                    continue;
                }
            }
            if(sum < 200) {
                if(carry==0) carry = sum - weight[pright];
                else carry -= weight[pright];
                pleft++;
            } else if(sum == 200) {
                result++;
                pleft++;
                pright--;
                carry=0;
            } else {
                if(sum - weight[pleft]<200) {
                    result++;
                    pright--;
                    carry=0;
                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{100, 200, 100, 150, 80, 30, 20};
        System.out.println("The minimum boat needed is: " + computeBoat(test1));
    }
}
