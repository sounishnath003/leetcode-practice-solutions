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
    
    private ListNode mergeNodes(ListNode one, ListNode two) {
        ListNode head1 = one;
        ListNode head2 = two;
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        
        while(head1 != null && head2 !=null) {
            int data1 = head1.val;
            int data2 = head2.val;
            
            if (data1 < data2) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            } else {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        
        if (head1 != null) temp.next = head1;
        if (head2 != null) temp.next = head2;
        
        return dummy.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        // VERY BAD SOLUTION
        // AMORTIZED COMPLEXITY ~ O(N * K^2) ~ O(N^3) [if K is really Huge]
//         ListNode res = null;
//         for (int i = 0; i < lists.length; i++) {
//             if (lists[i] != null)
//                 res = this.mergeNodes(lists[i], res);
//         }
        
//         return res;
    
       
        // GOOD AND OPTIMIZED SOLUTION
        // TIME - O(N * kLongK) []
        // SPACE - O(K) [size of k nodes]
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode node : lists)
            if (node != null)
                priorityQueue.add(node);   
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        
        while(priorityQueue.isEmpty()==false) {
            ListNode t = priorityQueue.poll();
            
            if (t.next != null) priorityQueue.add(t.next);
            
            temp.next = t;
            temp = temp.next;
        }
        
        return dummy.next;
    }
}
