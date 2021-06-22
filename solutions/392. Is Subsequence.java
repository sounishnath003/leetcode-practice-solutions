class Solution {
    public boolean isSubsequence(String s, String t) {
        // s ki t er subsequence
        
        // checking if any string is a subsequence of another string
        // in O(N)
        
        int prevIdx = 0;
        for (char c : s.toCharArray()) {
            int foundIndex = t.indexOf(c, prevIdx);
            if (foundIndex == -1) return false;
            prevIdx = foundIndex + 1;
        }
        
        return true;
    }
}
