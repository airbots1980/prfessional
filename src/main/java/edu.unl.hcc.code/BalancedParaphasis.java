package edu.unl.hcc.code;

import edu.unl.hcc.service.common.StringUtils;
import java.util.Stack;

/**
 * You're given a string consisting solely of (, ), and *. * can
 * represent either a (, ), or an empty string. Determine whether
 * the parentheses are balanced.
 *
 * For example, (()* and (*) are balanced. )*( is not balanced.
 */
public class BalancedParaphasis {
    String target;
    public boolean isBalanced(String str) {
        //boundary conditions
        if(StringUtils.isEmpty(str)) return true;
        target = str;
        Stack s = new Stack<Character>();
        return helper(s, str.charAt(0), 0);
    }

    private boolean helper(Stack s, char cur, int idx) {
        Stack local = (Stack)s.clone();

        if(cur=='*') {
            return helper(local, '(', idx)
                || helper(local, ')', idx)
                || helper(local, (char) 0, idx);
        } else if (cur==0){
            if(idx==target.length()-1) {
                if(local.isEmpty()) return true;
                else return false;
            } else {
                return helper(s, target.charAt(idx+1),idx+1);
            }
        } else if(cur=='(') {
            if(idx==target.length()-1) return false;
            else {
                local.push(cur);
                return helper(local, target.charAt(idx+1), idx + 1);
            }
        } else if(cur==')') {
            if(local.isEmpty()) return false;
            else {
                char match = (Character)local.pop();
                if(match!='(') return false;
                else {
                    if(idx==target.length()-1) {
                        if(local.isEmpty()) return true;
                        else return false;
                    }
                    else return helper(local, target.charAt(idx+1), idx+1);
                }
            }
        } else return false;
    }

    public static void main(String[] args) {

        BalancedParaphasis b = new BalancedParaphasis();
        System.out.println("Test for null is: "+ b.isBalanced(null));
        System.out.println("Test for ((*) is: "+ b.isBalanced("((*)"));
        System.out.println("Test for * is: "+ b.isBalanced("*"));
        System.out.println("Test for ( is: "+ b.isBalanced("("));
        System.out.println("Test for ) is: "+ b.isBalanced(")"));
        System.out.println("Test for )*( is: "+ b.isBalanced(")*("));
        System.out.println("Test for ()( is: "+ b.isBalanced("()("));



    }
}
