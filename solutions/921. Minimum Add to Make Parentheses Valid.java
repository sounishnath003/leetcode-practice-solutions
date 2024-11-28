class Solution {
    public int minAddToMakeValid(String s) {
        int openBracketCount=0;
        int closeBracketCount=0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') openBracketCount++;
            else if (c == ')' && openBracketCount > 0) openBracketCount--;
            else closeBracketCount++;
        }
        
        return openBracketCount + closeBracketCount;
    }
}
