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
    public void reorderList(ListNode head) {
        fold(head);    
    }
    
    public void fold(ListNode head) {
        /*
            1: Segregate the 1 and 2 halves
            2: Reverse 2nd Half
            3: Make Connections using proper logic
            4: Match Output using PrintList
         */
​
        ListNode middle_node = getMiddleNode(head);
        ListNode th = middle_node.next;
        ListNode head2 = reverse(th);
        middle_node.next = null;
​
        ListNode t1 = head;
        ListNode t2 = head2;
​
        while (t1 != null && t2 != null){
            ListNode n1 = t1.next;
            ListNode n2 = t2.next;
​
            t1.next = t2;
            t2.next = n1;
​
            t1 = n1;
            t2 = n2;
        }
    }
​
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
​
        while (curr != null) {
            ListNode next = curr.next;
​
            curr.next = prev;
            prev = curr;
​
            curr = next;
        }
​
        return prev;
    }
​
    private ListNode getMiddleNode(ListNode head) {
        ListNode slow_pointer = head;
        ListNode fast_pointer = head;
​
        while (fast_pointer.next != null && fast_pointer.next.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
        }
​
        return slow_pointer;
    }
​
}
