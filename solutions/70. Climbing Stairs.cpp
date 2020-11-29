class Solution {
    private:
    int memo[46] = {-1};
public:
    Solution() { memo[0] = memo[1] = 1 ; }
    int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        if(memo[n]){ return memo[n] ; }
        return memo[n] = climbStairs(n - 1) + climbStairs(n - 2);
    }
};
