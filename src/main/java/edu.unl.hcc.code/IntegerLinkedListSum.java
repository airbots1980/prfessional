import edu.unl.hcc.leetcode.ListNode;
import java.util.Arrays;
import java.util.List;

/**
 * Let's represent an integer in a linked list format by having each node represent a digit in the number. The nodes make up the number in reversed order.
 *
 * For example, the following linked list:
 *
 * 1 -> 2 -> 3 -> 4 -> 5
 * is the number 54321.
 *
 * Given two linked lists in this format, return their sum in the same linked list format.
 *
 * For example, given
 *
 * 9 -> 9
 * 5 -> 2
 * return 124 (99 + 25) as:
 *
 * 4 -> 2 -> 1
 */
public class IntegerLinkedListSum {

    public static ListNode sumLinkedList(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        else if(l2==null) return l1;
        //iteratively traverse the lists, then add them up.
        ListNode current;
        current = l1;
        int carry =0;
        while(l1!=null||l2!=null) {

            int left = l1==null?0:l1.val;
            int right = l2==null?0:l2.val;
            int sum = left+right+carry;
            if(left+right+carry>9) {
                carry = sum/10;
                sum = sum%10;
            } else {
                carry = 0;
            }
            if(current!=null) {
                current.val = sum;
            }

            //boundary conditions
            l2=l2==null?null:l2.next;
            l1=l1==null?null:l1.next;
            if(l1==null&&l2==null) {
                if(carry ==0 ) break;
                else {
                    current.next=new ListNode(carry);
                    break;
                }
            }
            System.out.println(current.val);
            current=current.next;
        }
        return l1;
    }

    static ListNode buildList(List<Integer> array) {
        if(array==null) return null;
        ListNode root=null;
        ListNode next=null;
        for(Integer i: array) {
            if(root==null) {
                root= new ListNode(i);
                next=root;
            }else {
                next.next=new ListNode(i);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode l1 = buildList(Arrays.asList(5,4,3));
        ListNode l2 = buildList(Arrays.asList(4,6,7));
        ListNode result = sumLinkedList(l1, l2);
        while(result!=null) {
            System.out.print(result.val+", ");
            result=result.next;
        }
    }
}
