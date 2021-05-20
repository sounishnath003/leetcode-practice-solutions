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
    public ListNode deleteDuplicates(ListNode head) {
         ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
​
        while (head != null) {
​
            if (head.next != null && head.val == head.next.val) {
                // skipping the duplicate nodes
                while (head.next != null && head.val == head.next.val)
                    head = head.next;
                temp.next = head.next;
            }
​
            else {
                temp.next = head;
                temp = temp.next;
            }
​
            head = head.next;
        }
        return dummy.next;
    }
}
