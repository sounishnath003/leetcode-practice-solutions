class Solution {
    public int titleToNumber(String columnTitle) {
        // sum of (26 * X + newCharY) thats the essence of the problem
        
        int sum = 0;
        for (char x : columnTitle.toCharArray())
            sum = (sum * 26) + ( x - 'A' + 1 );
        
        return sum;
    }
}
