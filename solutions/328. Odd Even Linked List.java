class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode doddIndices = new ListNode(-1);
        ListNode devenIndices = new ListNode(-1);
​
        ListNode oddIndices = doddIndices;
        ListNode evenIndices = devenIndices;
        ListNode node = head;
        int index = 0;
        while (node != null) {
            boolean isEven = (index % 2 == 0);
            if (isEven) {
                evenIndices.next = new ListNode(node.val);
                evenIndices = evenIndices.next;
            } else {
                oddIndices.next = new ListNode(node.val);
                oddIndices = oddIndices.next;
            }
            node = node.next;
            index++;
        }
        evenIndices.next = doddIndices.next;
        return devenIndices.next;
    }
}
