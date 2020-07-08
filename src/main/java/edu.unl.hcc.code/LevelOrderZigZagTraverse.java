package edu.unl.hcc.code;

import java.util.LinkedList;
import java.util.List;

/**
 * fangshi li asked question,
 *
 * also merge sort, quick sort, top K element, etc.
 */

public class LevelOrderZigZagTraverse {

    class TreeNode {

        public TreeNode left;
        public TreeNode right;
        int value;

        public TreeNode(){
            left = null;
            right = null;
        }

        public TreeNode(int val){
            value = val;
        }
    }

    public void levelOrderTraverseII(TreeNode root) {

        //boundary conditions check
        if(root==null) return;
        else if (isLeaf(root)) System.out.println(root.value);

        //general cases
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);
        boolean flag=false;

        while(!q.isEmpty()){
            TreeNode cur;
            List<TreeNode> children = new LinkedList<TreeNode>();
            while(!q.isEmpty()){
                //print all nodes in q
                if(flag) {
                    cur = q.poll();
                    if(cur.left!=null) children.add(cur.left);
                    if(cur.right!=null) children.add(cur.right);
                } else {
                    cur = q.removeLast();
                    if(cur.right!=null) children.add(0, cur.right);
                    if(cur.left!=null) children.add(0,cur.left);

                }
                System.out.print(cur.value + " ");
            }
            flag = !flag;
            //add back all children to q
            q.addAll(children);
        }
    }

    private boolean isLeaf(TreeNode root){
        if(root==null) return false;
        if(root.left==null && root.right==null) return true;
        return false;
    }

    private TreeNode createTree() {
        TreeNode test0= new TreeNode(0);
        TreeNode test1= new TreeNode(1);
        TreeNode test2= new TreeNode(2);
        TreeNode test3= new TreeNode(3);
        TreeNode test4= new TreeNode(4);
        TreeNode test5= new TreeNode(5);
        test0.left = test1;
        test0.right = test2;
        test1.left = test3;
        test2.left = test4;
        test2.right = test5;
        return test0;
    }

    public static void main(String[] args) {
        LevelOrderZigZagTraverse s = new LevelOrderZigZagTraverse();
        //test cases
        //1. root = null
        //2. root = leaf
        //3. general cases
        //4. huge tree case, may not cover here
        TreeNode root = s.createTree();
        s.levelOrderTraverseII(root);
    }
}
