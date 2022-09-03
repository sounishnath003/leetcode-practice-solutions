class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> rslt = new ArrayList<Double>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()){
            int sz = q.size();
            long cursum = 0, numval = 0;
            while (sz-- > 0){
                TreeNode cur = q.poll();
                cursum += cur.val;
                numval += 1;
                
                if (cur.left != null){
                    q.offer(cur.left);
                }
                if (cur.right != null){
                    q.offer(cur.right);
                }
            }
            rslt.add( 1.0*cursum / numval);
        }
        return rslt;
     }
}
