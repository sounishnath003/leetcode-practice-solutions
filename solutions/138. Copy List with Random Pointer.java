class Node {
    int val;
    Node next;
    Node random;
​
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
​
class Solution {
    public Node copyRandomList(Node head) {
        // create a duplicate LL
        Node current = head;
        
        while (current != null) {
            Node nextnode = current.next;
            Node newnode = new Node(current.val);
            current.next = newnode;
            newnode.next = nextnode;
            current = nextnode;
        }
        
        current = head;
        // set the random pointers
        while (current != null) {
            current.next.random = current.random != null ? current.random.next : null;
            current = current.next.next;
        }
        
        // connect wisely
        current = head;
        Node dummy = new Node(-1);
        Node temp = dummy;
        
        while (current!=null) {
            temp.next = current.next;
            temp = current.next;
            current.next = current.next.next;
            current = current.next;
        }
        return dummy.next;
    }
    
    public Node copyRandomListBruteForce(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node current = head;
        while (current!=null) {
            nodeMap.put(current, new Node(current.val));
            current = current.next;
        }
​
        current = head;
        while (current!=null) {
            Node node = nodeMap.get(current);
            node.next = nodeMap.get(current.next);
            node.random = nodeMap.get(current.random);
            current = current.next;
        }
​
        return nodeMap.get(head);
    }
}
