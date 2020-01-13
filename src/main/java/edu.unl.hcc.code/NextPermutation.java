import org.apache.commons.lang.math.NumberUtils;

/**
 * Given an integer, find the next permutation of it in absolute order.
 * For example, given 48975, the next permutation would be 49578.
 */
public class NextPermutation {

    public static int findCircularPer(int num) {

        int len=0;
        //    len = NumberUtils.getDigitNum(num);
        int current = num;
        int result = Integer.MIN_VALUE;
        while(true) {
            System.out.println(current);
            int rem = current%10;
            int dev = current/10;
            current = (int) (Math.pow(10, len-1)*rem + dev);
            if(num == current) break;
        }
        return result;
    }

    public static long findNextLargerPermutation(int num) {
        char[] number = String.valueOf(num).toCharArray();
        long result;
        for(int i=number.length-1;i>0;i--) {
            if(number[i]>number[i-1]){
                char c = number[i];
                number[i]=number[i-1];
                number[i-1]=c;
                result = Long.parseLong(new String(number));
                return result;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.printf("The next permutation of 48975 is: %d",findNextLargerPermutation(48975));

    }
}
