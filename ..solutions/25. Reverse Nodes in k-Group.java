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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k==1) return head;
​
        ListNode start = head;
        ListNode end = getEndNode(start, k);
        ListNode recursiveHead = reverseKGroup(end.next, k);
        reverseInRange(start, end);
        start.next = recursiveHead;
        return end;
    }
​
    private void reverseInRange(ListNode start, ListNode end) {
        ListNode previous = null;
        ListNode current = start;
​
        while (previous != end) {
            ListNode nextnode = current.next;
            current.next = previous;
            previous = current;
            current = nextnode;
        }
    }
​
    private ListNode getEndNode(ListNode start, int k) {
        ListNode end = start;
        int inc = k-1;
        while (inc > 0) {
            end = end.next;
            if (end == null) return start;
            inc--;
        }
        return end;
    }
}
