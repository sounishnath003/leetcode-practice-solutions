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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode mid_node = getMidOf(head);
        ListNode start = head;
        ListNode end = mid_node.next;
        mid_node.next = null;
        
        start = sortList(start);
        end = sortList(end);
        
        ListNode merged_list = mergeList(start, end);
        return  merged_list;
    }
​
    private ListNode mergeList(ListNode start, ListNode end) {
        ListNode t1 = start;
        ListNode t2 = end;
        
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        
        while (t1 != null && t2 != null) {
            int a = t1.val;
            int b = t2.val;
            
            if (a < b) {
                tmp.next = t1;
                t1 = t1.next;
            } else {
                tmp.next = t2;
                t2 = t2.next;
            }
            tmp = tmp.next;
        }
        
        if (t1 != null) tmp.next = t1;
        if (t2 != null) tmp.next = t2;
        
        return dummy.next;
    }
​
    private ListNode getMidOf(ListNode head) {
        ListNode slow_pointer = head;
        ListNode fast_pointer = head;
        
        while (fast_pointer.next != null && fast_pointer.next.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
        }
        
        return slow_pointer;
    }
}
