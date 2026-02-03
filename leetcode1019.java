import java.lang.classfile.components.ClassPrinter.ListNode;
import java.util.Arrays;
import java.util.Stack;

public class leetcode1019 {
    public static void main(String[] args) {
        
    }

    /*1019. Next Greater Node In Linked List
Medium
Topics
premium lock icon
Companies
Hint
You are given the head of a linked list with n nodes.

For each node in the list, find the value of the next greater node. That is, for each node, 
find the value of the first node that is next to it and has a strictly larger value than it.

Return an integer array answer where answer[i] is the value of the next greater
 node of the ith node (1-indexed).
 If the ith node does not have a next greater node, set answer[i] = 0.

 

Example 1:


Input: head = [2,1,5]
Output: [5,5,0]
Example 2:


Input: head = [2,7,4,3,5]
Output: [7,0,5,5,0]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 104
1 <= Node.val <= 109 */

 public static int[] nextLargerNodes(ListNode head) {
        int len = 0;
        ListNode temp =head;
        while(temp != null)
        {
            temp = temp.next;
            len++;
        }
        int []arr = new int[len];
        int i=0;
        temp = head;
        while(temp != null)
        {
            arr[i++] = temp.val;
            temp = temp.next;
        }
      int []result = new int[len];
      Arrays.fill(result, 0);
      Stack<Integer> stack = new Stack<>();
      temp = head;
      int idx = 0;
      for( i=0; i<arr.length; i++)
      {
        while(!stack.isEmpty() && arr[i] > arr[stack.peek()])
        {
           int index =  stack.pop();
            result[index] = arr[i];
        }

        stack.push(i);
      }

      return result;    
}

}
