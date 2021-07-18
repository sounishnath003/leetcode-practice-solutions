            this.size--;
            return data;
        }
    }
}
​
class Solution {
​
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        LinkedListt list = new LinkedListt();
        
        // putting all the nodes in a linked list
        while (head != null) {
            list.addLast(head.val);
            head = head.next;
        }
​
        LinkedListt result = null; // stores final answer
​
        while (list.size > 0) {
            int size = list.size;
            LinkedListt temp = new LinkedListt();
            
            if (size >= k) {
                // remove first
                // add first
                // which will reverse the linkedlist
​
                for (int i = 0; i < k; i++) {
                    int data = list.removeFirst();
                    temp.addFirst(data);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    int data = list.removeFirst();
                    temp.addLast(data);
                }
            }
​
            if (result == null) {
                result = temp;   
            } else {
                result.tail.next = temp.head;
                result.tail = temp.tail;
                result.size += temp.size;
​
            }
        }
    
        head = result.head;
        
        return head;
    }
}
​
