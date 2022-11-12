class Solution {
    private List<String> lists = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        _generateParenthesis("",0,0,n);
        return this.lists;
    }
    
    private void _generateParenthesis(String s, int openCount, int closeCount, int n) {
        
        if (closeCount > openCount)
            return ;
        
        if (openCount == closeCount && s.length() == 2*n){
            this.lists.add(s);
            return ;
        }
        
        // faith
        if (openCount <= n)
            _generateParenthesis(s + "(", openCount + 1, closeCount, n);
        
        if (openCount > closeCount)
        _generateParenthesis(s + ")" , openCount, closeCount + 1, n);
    }
}
