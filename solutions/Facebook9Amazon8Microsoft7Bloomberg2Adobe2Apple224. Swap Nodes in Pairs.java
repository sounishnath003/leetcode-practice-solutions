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
    public ListNode swapPairs(ListNode head) {
        // if single node or NULL return itself....
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode rres=swapPairs(head.next.next);
        
        ListNode nextnode=head.next;
        nextnode.next=head;
        head.next=rres;
        
        return nextnode;
    }
}
