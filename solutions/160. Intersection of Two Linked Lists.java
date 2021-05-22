/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private int getSize(ListNode node) {
        ListNode temp = node;
        int count = 0;
        while(temp != null) {count++; temp = temp.next;}
        return count;
    }
    public ListNode getIntersectionNode(ListNode one, ListNode two) {
            int size1 = this.getSize(one);
            int size2 = this.getSize(two);
            
            if (size1 > size2) {
                ListNode head1 = this.getIntersectionPoint(one, two, size1, size2);
                return head1;
            } else {
                ListNode head2 = this.getIntersectionPoint(two, one, size2, size1);
                return head2;
            }
    }
    
    private ListNode getIntersectionPoint(ListNode head1, ListNode head2, int size1, int size2) {
            int diff = size1 - size2;
            while(diff > 0) {
                head1 = head1.next;
                diff--;
            }
            
            while(head1 != head2) {
                head1 = head1.next;
                head2 = head2.next;
            }
            return head1;
        }
}
