/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        return optimized(head);
    }
​
    private ListNode optimized(ListNode head) {
        if (head == null || head.next == null) return null;
        // use of two pointer technique
        ListNode slow = head;
        ListNode fast = head;
        boolean found=false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast=fast.next.next;
            if (fast == slow) {
                found=true;
                break;
            }
        }
        if (!found) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
