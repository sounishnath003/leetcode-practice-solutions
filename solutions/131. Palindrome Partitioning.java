class Solution {
    /*
        * Not too tough; just focus on recursion steps
        * backtrack when conditions satisfies
        * algorithm / psuedo code looks somethign like this!! 
        * very easy and stay focus on recursion steps!
        * for (i 0 to s.len){
                if (ispalindrome(s, curIdx, i)) {
                    if (i==curIdx) curans.add(s[i])
                    else curans.add(s.substring(idx, i+1))
                    f(s, i+1);
                    curans.pop_back();
                }
           }
    */
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        generatePalindromeStrings(s, 0, ans, new ArrayList<>());
        return ans;
    }
​
    private void generatePalindromeStrings(String s, int idx, List<List<String>> ans, ArrayList<String> currentAns) {
        // TODO Auto-generated method stub
        if (currentAns.size() > 0 && idx >= s.length()) {
            List<String> aans = (List<String>) currentAns.clone();
            ans.add(aans);
        }
        
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                if (idx == i) currentAns.add("" + s.charAt(i));
                else currentAns.add(s.substring(idx, i+1));
                // faith
                // ** I will get next indices answers eventually
                generatePalindromeStrings(s, i+1, ans, currentAns);
                currentAns.remove(currentAns.size() - 1); // backtracking to prev.state
            } else continue ;
        }
    }
​
    private boolean isPalindrome(String s, int idx, int j) {
        // TODO Auto-generated method stub
        if (idx==j) return true;
        while(idx < j) {
            if (s.charAt(idx) != s.charAt(j)) return false;
            else {
                idx++;
                j--;
            }
        }
        return true;
    }
}
