class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k==0||head==null||head.next==null) return head;
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }
​
        current.next = head;
        k = k % length;
        int diff = length - k;
​
        while (diff > 0) {
            diff--;
            current = current.next;
        }
​
        head = current.next;
        current.next = null;
        
        return head;
    }
​
    private int getLength(ListNode head) {
        if (head == null) return 0;
​
        int count = 1;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
​
    private ListNode getLastNode(ListNode head) {
        ListNode current = head;
        while (current.next != null)
            current = current.next;
​
        return current;
    }
}
