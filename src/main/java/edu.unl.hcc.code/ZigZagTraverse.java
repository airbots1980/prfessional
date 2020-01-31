package edu.unl.hcc.code;

import edu.unl.hcc.leetcode.TreeNode;
import edu.unl.hcc.leetcode.utils.TreeUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * In Ancient Greece, it was common to write text with the first
 * line going left to right, the second line going right to left,
 * and continuing to go back and forth. This style was called "boustrophedon".
 *
 * Given a binary tree, write an algorithm to print the nodes in boustrophedon order.
 *
 * For example, given the following tree:
 *
 *        1
 *     /     \
 *   2         3
 *  / \       / \
 * 4   5     6   7
 * You should return [1, 3, 2, 4, 5, 6, 7].
 */

public class ZigZagTraverse {

    public static List<Integer> printTree(TreeNode root) {
        //boundary conditions
        if(root==null) return null;
        List<Integer> result = new ArrayList();
        boolean reverse=true;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        //bfs
        while(queue.size()>0) {
            List<TreeNode> c = new LinkedList();
            List<Integer> level = new ArrayList();
            while(!queue.isEmpty()) {
                TreeNode current = queue.poll();
                if(current.left!=null) c.add(current.left);
                if(current.right!=null) c.add(current.right);
                if(reverse){
                    level.add(current.val);
                } else {
                    level.add(0, current.val);
                }
            }
            //add the next level
            queue.addAll(c);
            reverse = !reverse;
            result.addAll(level);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] tree = new int[]{4,2,5,1,6,3,7};
        TreeNode root = TreeUtils.createTree(tree,0);
        System.out.println(printTree(root));
    }
}
