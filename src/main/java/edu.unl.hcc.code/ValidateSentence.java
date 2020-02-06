import edu.unl.hcc.service.common.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Assert;

/**
 * Create a basic sentence checker that takes in a stream of
 * characters and determines whether they form valid sentences.
 * If a sentence is valid, the program should print it out.
 *
 * We can consider a sentence valid if it conforms to the following rules:
 *
 * 1. The sentence must start with a capital letter, followed by a
 *    lowercase letter or a space.
 *
 * 2. All other characters must be lowercase letters, separators
 *    (,,;,:) or terminal marks (.,?,!,‽).
 *
 * 3. There must be a single space between each word.
 *
 * 4. The sentence must end with a terminal mark immediately following a word.
 */
public class ValidateSentence {

    static Character[] tmp = new Character[]{'.','?','!'};
    private static Set<Character> TERMINALS = new HashSet();

    static Character[] tmp1 = new Character[]{',', ';', ':'};
    private static Set<Character> SEPARATORS = new HashSet();

    private static void init() {
        TERMINALS.addAll(Arrays.asList(tmp));
        SEPARATORS.addAll(Arrays.asList(tmp1));
    }

    public static boolean isValid(String sentence) {
        //boundary condition
        if(StringUtils.isEmpty(sentence)) return false;
        for(int i=0;i<sentence.length();i++) {
            char cur = sentence.charAt(i);
            if((i==0&&cur<='Z'&&cur>='A')||
                (cur<='z'&&cur>='a'&&i<sentence.length()-1)) {
                continue;
            }
            //if terminal
            if(isTerminal(cur)) {
                if(i!=sentence.charAt(i-1)) return false;
            }

            //current is blank, previous can not be
            if(cur==' ') {
                if(i!=0&&sentence.charAt(i-1)==' ') return false;
            }
            //separator case
            if(isSeparator(cur)) {
                if(i!=0) {
                    if (isSmallCase(sentence.charAt(i - 1)) ||
                        isCapitalCase(sentence.charAt(i-1))) continue;
                    else return false;
                } else return false;
            }

            //if last char
            if(i==sentence.length()-1) {
                if(isTerminal(cur)) {
                    if (isSmallCase(sentence.charAt(i - 1)) ||
                        isCapitalCase(sentence.charAt(i-1))) return true;
                    else return false;
                } else return false;
            }
        }
        return true;
    }

    public static boolean isSmallCase(char c) {
        if(c<='z'&&c>='a') return true;
        return false;
    }

    public static boolean isCapitalCase(char c) {
        if(c<='Z'&&c>='A') return true;
        return false;
    }

    private static boolean isTerminal(char c) {
        if(TERMINALS.contains(c)) return true;
        return false;
    }

    private static boolean isSeparator(char c) {
        if(SEPARATORS.contains(c)) return true;
        return false;
    }

    public static void main(String[] args) {
        String test1 = "An apple is an apple!";
        String test2 = "";
        String test3 = null;
        String test4 = "A star on the sky.";
        String test5 = "iMportant information,  ";
        String test6 = "No  pain no gains.";
        String test7 = "Is this correct ?";
        String test8 = "Is this correct?";
        String test9 = "Where there is a WILL, there is a way.";
        String test10 = "Where there is a will, There is a way.";
        String test11 = "Where there is a will , There is a way.";
        Assert.assertTrue(test1, isValid(test1));
    }
}
