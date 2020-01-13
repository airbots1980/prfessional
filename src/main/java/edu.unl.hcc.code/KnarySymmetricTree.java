import java.util.LinkedList;
import java.util.Queue;
import org.apache.commons.lang.StringUtils;

public class KnarySymmetricTree {

    public static boolean isSym(GenericTreeNode root) {
        if(root==null||isLeaf(root)) return true;
        Queue<GenericTreeNode> q = new LinkedList();
        q.add(root);
        while(q.size()>0) {
            Queue<GenericTreeNode> subQ = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            while(q.size()>0) {
                GenericTreeNode t = q.poll();
                sb.append(t.value);
                for(GenericTreeNode child: t.children) {
                    subQ.add(child);
                }
            }
            if(!isPalindrome(sb.toString())) return false;
            q.addAll(subQ);
        }
        return true;
    }

    private static boolean isLeaf(GenericTreeNode node) {
        if(node!=null&&(node.children==null||node.children.size()==0)) return true;
        return false;
    }

    private static boolean isPalindrome(String str) {
        if(StringUtils.isEmpty(str)||str.length()==1) return true;
        int left=0;
        int right = str.length()-1;
        while(left<right) {
            if(str.charAt(left)!=str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}