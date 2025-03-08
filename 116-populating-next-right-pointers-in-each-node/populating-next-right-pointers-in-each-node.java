class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        
        Node current = root;
        while(current.left != null) {
            Node temp = current;
            while(current != null) {
                current.left.next = current.right;
                current.right.next = current.next == null ? null : current.next.left;
                current = current.next;
            }

            current = temp.left;
        }    
        return root;
    }
}