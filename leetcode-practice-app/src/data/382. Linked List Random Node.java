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
​
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode root = null;
    public Solution(ListNode head) {
        this.root = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int i =1, ans = 0;
        ListNode tmp = this.root;
        while(tmp != null) {
            if(Math.random() < 1.0/i ) {
                ans = tmp.val;
            }
            i++;
            tmp = tmp.next;
        }
        return ans;
    }
}
​
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
