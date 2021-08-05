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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return this.IntersectionNodeInTwoLL(headA, headB) ;
    }
    
    public ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        int n = getLength(headA);
        int m = getLength(headB);
​
        int diff = Math.abs(n - m);
        ListNode intersectionPoint = null;
​
        if (n > m) {
            intersectionPoint = getIntersection(headA, headB, diff);
        } else {
            intersectionPoint = getIntersection(headB, headA, diff);
        }
​
        return intersectionPoint;
    }
​
    private ListNode getIntersection(ListNode headA, ListNode headB, int diff) {
​
        ListNode slow = headB;
        ListNode fast = headA;
​
        for (int i = 0; i < diff; i++) fast = fast.next;
​
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
​
        return slow;
    }
​
    private static int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }
​
    
}
