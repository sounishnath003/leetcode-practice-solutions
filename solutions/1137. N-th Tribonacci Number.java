class Solution {
    Map<Integer,Integer> memo = new HashMap<>();
    public Solution(){
        memo.put(0,0);
        memo.put(1,1);
        memo.put(2,1);
        memo.put(3,2);
    }
    public int tribonacci(int n) {  
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int s= tribonacci(n-3)+tribonacci(n-2)+tribonacci(n-1); 
        memo.put(n,s);
        return s;
    }
​
}
