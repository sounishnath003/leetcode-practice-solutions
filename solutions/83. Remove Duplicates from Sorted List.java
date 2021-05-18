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
    public ListNode deleteDuplicates(ListNode root) {
        ListNode dummy = new ListNode(-9999999);
        ListNode temp = dummy;
​
        ListNode head = root;
        while(head != null) {
            if(temp.val != head.val) {
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
