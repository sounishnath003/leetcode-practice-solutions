class Solution {
    public int minPartitions(String n) {
        int ans = n.charAt(0) - '0';
        for (int i = 1; i < n.length(); i++) {
            int x = n.charAt(i) - '0';
            ans = Math.max(ans, x);
        }
        return ans;
    }
}
