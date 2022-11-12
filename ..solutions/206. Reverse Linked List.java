/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        return iterativeReverse(head);
    }
    public ListNode iterativeReverse(ListNode node) {
        ListNode previous = null;
        ListNode current = node;
        while (current != null) {
            ListNode nextnode = current.next;
            current.next = previous;
            previous = current;
            current = nextnode;
        }
        return previous;
    }
    public ListNode recursiveReverse(ListNode node) {
        if (node.next==null)
            return node;

        ListNode newhead = recursiveReverse(node.next);
        node.next.next = node;
        node.next = null;

        return newhead;
    }
}
