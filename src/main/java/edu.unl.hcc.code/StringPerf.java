/**
 * Results
 *
 * 1000 run
 * Time consumed for new String is: 33
 * Time consumed for String.valueOf is: 3
 * Time consumed for Arrays.toString() is: 190
 * Time consumed for StringBuilder is: 102
 *
 * 100000 run
 * Time consumed for new String is: 109
 * Time consumed for String.valueOf is: 22
 * Time consumed for Arrays.toString() is: 1079
 * Time consumed for StringBuilder is: 784
 *
 * 1000000 run
 * Time consumed for new String is: 341
 * Time consumed for String.valueOf is: 320
 * Time consumed for Arrays.toString() is: 7946
 * Time consumed for StringBuilder is: 7853
 *
 * 10000000 run
 *
 * Time consumed for new String is: 2256
 * Time consumed for String.valueOf is: 1694
 * Time consumed for Arrays.toString() is: 75047
 * Time consumed for StringBuilder is: 74882
 */

import java.util.Arrays;

public class StringPerf {

    public static void createStringFromChar(char[] testCase, int range) {
        long t1, t2, t3;
        t1=System.currentTimeMillis();
        for(int i=0;i<range;i++) {
            String str1=new String(testCase);
        }
        t1=System.currentTimeMillis()-t1;
        System.out.println("Time consumed for new String is: "+ t1);
        t2=System.currentTimeMillis();
        for(int i=0;i<range;i++) {
            String str2=String.valueOf(testCase);
        }
        t2=System.currentTimeMillis()-t2;
        System.out.println("Time consumed for String.valueOf is: "+ t2);
        t3=System.currentTimeMillis();
        for(int i=0;i<range;i++) {
            String str3= Arrays.toString(testCase);
        }
        t3=System.currentTimeMillis()-t3;
        System.out.println("Time consumed for Arrays.toString() is: "+ t3);

        long t4=System.currentTimeMillis();
        for(int i=0;i<range;i++) {
            StringBuilder sb = new StringBuilder();
            for(char c: testCase) {
                sb.append(c);
            }
            String str4= sb.toString();
        }
        t4=System.currentTimeMillis()-t4;
        System.out.println("Time consumed for StringBuilder is: "+ t4);
    }

    public static void main(String[] args) {
        char[] testCase = ("").toCharArray();
        createStringFromChar(testCase, 10000);
    }
}
