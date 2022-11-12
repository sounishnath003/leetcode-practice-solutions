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
class Solution {
    private ListNode curr = null;
    public boolean isPalindrome(ListNode head) {
        curr = head;
        boolean result = _isPalindrome(head);
        return result;
    }
​
    private boolean _isPalindrome(ListNode head) {
​
        if (head == null) {
            return true;
        }
​
        // faith
        boolean rres = _isPalindrome(head.next);
        if (rres == false) return false;
​
        boolean my_status = head.val == curr.val;
        curr = curr.next;
​
        return my_status;
    }
}
