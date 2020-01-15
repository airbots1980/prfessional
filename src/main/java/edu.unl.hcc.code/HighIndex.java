import java.util.Arrays;

/**
 * In academia, the h-index is a metric used to calculate the impact of a
 * researcher's papers. It is calculated as follows:
 *
 * A researcher has index h if at least h of her N papers have h citations
 * each. If there are multiple h satisfying this formula, the maximum is chosen.
 *
 * For example, suppose N = 5, and the respective citations of each paper
 * are [4, 3, 0, 1, 5]. Then the h-index would be 3, since the researcher has
 * 3 papers with at least 3 citations.
 *
 * Given a list of paper citations of a researcher, calculate their h-index.
 */
public class HighIndex {

    public static int findHI(int[] citations) {
        if(citations==null||citations.length==0) return 0;
        Arrays.sort(citations);
        int result = 0;
        int total = citations.length;
        for(int i=0;i<total;i++) {
            if(total-i-1>citations[1]&&result<citations[i]) {
                result = citations[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{4,3,0,1,5};
        int[] test2 = new int[]{1,2,2,1,1};
        int[] test3 = new int[]{1,1,1,1,1};
        System.out.println("HighIndex of test1 is:" + findHI(test1));
        System.out.println("HighIndex of test2 is:" + findHI(test2));
        System.out.println("HighIndex of test3 is:" + findHI(test3));



    }
}
