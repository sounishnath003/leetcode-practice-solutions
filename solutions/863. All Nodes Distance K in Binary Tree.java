        }
​
        return this.nodesAtKDistance;
    }
​
    private void printNodesWhichAreKLevelsDown(TreeNode node, int k, TreeNode blocker) {
​
        if (node == null || node == blocker || k < 0)
            return;
​
        if (k == 0) {
            nodesAtKDistance.add(node.val);
            return;
        }
​
        // faith
        this.printNodesWhichAreKLevelsDown(node.left, k - 1, blocker); // left call
        this.printNodesWhichAreKLevelsDown(node.right, k - 1, blocker); // right call
    }
​
    private ArrayList<TreeNode> getTheNodeRootPath(TreeNode root, TreeNode target) {
​
        if (root == null)
            return new ArrayList<>();
​
        if (root == target) {
            ArrayList<TreeNode> bres = new ArrayList<>();
            bres.add(root);
            return bres;
        }
​
        // faith
        ArrayList<TreeNode> path1 = this.getTheNodeRootPath(root.left, target);
        ArrayList<TreeNode> path2 = this.getTheNodeRootPath(root.right, target);
​
        ArrayList<TreeNode> mypath = new ArrayList<>();
​
        if (path1.size() > 0) {
            mypath = path1;
            mypath.add(root);
        } else {
            mypath = path2;
            mypath.add(root);
        }
​
        return mypath;
    }
​
}
