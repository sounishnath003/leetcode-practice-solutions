class Solution {
    public int goodNodes(TreeNode root) {
        return f(root,root.val);
    }
    
    public int f(TreeNode root,int max) {
        if(root==null) return 0;
        
        int ans=0;
        if(max<=root.val) {
            max=root.val;
            ans++;
        }
        
        int l1 = f(root.left,max);
        int r1 = f(root.right,max);
        
        return ans+l1+r1;
    }
}
