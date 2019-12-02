package edu.unl.hcc.code;

import edu.unl.hcc.code.TreeNode;
import java.util.HashMap;

/**
 * Given the root of a binary tree, find the most frequent subtree sum. The subtree sum of a node is
 * the sum of all values under a node, including the node itself.
 *
 * <p>For example, given the following tree:
 *
 * <p>5 / \ 2 -5 Return 2 as it occurs twice: once as the left leaf, and once as the sum of 2 + 5 -
 * 5.
 */
public class MostFrequentSubtreeSum {

    static HashMap<Integer, Integer> freq= new HashMap();
    public static int find(TreeNode root) {
        if(root==null) return Integer.MIN_VALUE;
        dfs(root);
        int result=0;
        int val=0;
        for(int key: freq.keySet()) {
            if(freq.get(key)>result) {
                val=key;
            }
        }
        return val;
    }

    private static int dfs(TreeNode root) {
        if(root==null) return 0;
        int sum = root.val;
        if(root.left!=null) sum+= dfs(root.left);
        if(root.right!=null) sum+= dfs(root.right);
        if(freq.containsKey(sum)) freq.put(sum, freq.get(sum)+1);
        else freq.put(sum, 1);
        return sum;
    }

    public static void main(String[] args) {

    }
}
