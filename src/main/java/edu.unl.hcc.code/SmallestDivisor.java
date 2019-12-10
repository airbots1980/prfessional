import java.util.Arrays;

/**
 * Given an array of integers nums and an integer threshold, we will choose a positive integer
 * divisor and divide all the array by it and sum the result of the division. Find the smallest
 * divisor such that the result mentioned above is less than or equal to threshold.
 *
 * <p>Each result of division is rounded to the nearest integer greater than or equal to that
 * element. (For example: 7/3 = 3 and 10/2 = 5).
 *
 * <p>It is guaranteed that there will be an answer.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [1,2,5,9], threshold = 6 Output: 5 Explanation: We can get a sum to 17 (1+2+5+9)
 * if the divisor is 1. If the divisor is 4 we can get a sum to 7 (1+1+2+3) and if the divisor is 5
 * the sum will be 5 (1+1+1+2). Example 2:
 *
 * <p>Input: nums = [2,3,5,7,11], threshold = 11 Output: 3 Example 3:
 *
 * <p>Input: nums = [19], threshold = 5 Output: 4
 *
 * <p>Constraints:
 *
 * <p>1 <= nums.length <= 5 * 10^4 1 <= nums[i] <= 10^6 nums.length <= threshold <= 10^6
 */
public class SmallestDivisor {



    public static int smallestDivisor(int[] array, int thres) {
        if(array==null||array.length==0||thres < array.length) return 0;
        int result=findMax(array);
        int left = 1;
        int right = result;
        //binary search
        while(left<right) {
            int m = (left+right)/2;
            System.out.println(m);
            int sum = findSum(array, m);
            if(sum>thres) left=m+1;
            else right=m;
        }
        return left;
    }

    private static int findMax(int[] a) {
        int result = Integer.MIN_VALUE;
        for(int element: a) {
            result = element > result? element: result;
        }
        return result;
    }

    private static int findSum(int[] a, int val) {
        int sum=0;
        for(int element: a) {
            sum += element/val + (element%val==0?0:1);
            //System.out.printf("element is: %d, sum is: %d, divisor is: %d\n", element, sum, val);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,3,5,7,11};
        System.out.println("result is: " + smallestDivisor(array, 11));
    }
}
