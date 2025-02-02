public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode node) {
        this.addAllLeftChilds(node);
    }

    private void addAllLeftChilds(TreeNode root) {
        while (root != null) {
            this.stack.add(root);
            // move left side only
            root = root.left;
        }
    }

    public int next() {
        // if hasnext
        // then pop the elem from stack
        // check if it has right child
        // add all the right.leftchilds of the subtree into stack
        if (this.hasNext()) {
            TreeNode node = this.stack.pop();
            // has right?
            if (node.right != null) {
                this.addAllLeftChilds(node.right);
            }

            return node.val;
        }
        return -1;
    }

    public boolean hasNext() {
        // return if stack is empty
        return !this.stack.isEmpty();
    }

}
