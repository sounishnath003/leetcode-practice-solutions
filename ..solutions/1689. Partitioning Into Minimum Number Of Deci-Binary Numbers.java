class Solution {
    public int minPartitions(String n) {
        /*
            1) If the input has multiple digits, then you can solve for each digit independently, and merge the answers to form numbers that add up to that input.
            
            2) Thus the answer is equal to the max digit.
        */
        int ans = n.charAt(0) - '0';
        for (int i = 1; i < n.length(); i++) {
            int x = n.charAt(i) - '0';
            ans = Math.max(ans, x);
        }
        return ans;
    }
}
