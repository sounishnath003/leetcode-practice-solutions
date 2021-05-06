/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
     public TreeNode sortedListToBST(ListNode head) {
         if(head == null) return null;
         return _sortedListToBST(head, null);
    }
​
    private TreeNode _sortedListToBST(ListNode head, ListNode tailNode) {
        if (head == tailNode) return null;
        // find middle of the linekdList
        // 2 pointer approch
        ListNode fast = head;
        ListNode slow = head;        
        while (fast != tailNode && fast.next != tailNode){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = _sortedListToBST(head, slow);
        root.right = _sortedListToBST(slow.next, tailNode);
        return root;
    }
}
