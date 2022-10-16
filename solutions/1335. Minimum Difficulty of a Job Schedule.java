class Solution {
    public int minDifficulty(int[] k, int d) {
        if(d > k.length) return -1;
        
        //we now have a cache!
        //don't really need a row for the last day
        int[][] cache = new int[d-1][k.length];
        for(int[] day : cache) Arrays.fill(day, -1);
        
        return dfs(k, d-1, 0, cache);
    }
    
    private int dfs(int[] k, int d, int pos, int[][] cache) {
        //base case
        if(d == 0) {
            int max = k[pos];
            for(int i = pos; i < k.length; i++) max = Math.max(max, k[i]);
            return max;
        } 
        
        //just making sure we start indexing from 0
        int day = cache.length-d;
        
        //we already have this in the cache, just return it right here
        if(cache[day][pos] != -1) return cache[day][pos];
        
        // same logic as naive recursion
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = pos; i < k.length-d; i++) {
            max = Math.max(max, k[i]);
            min = Math.min(min, max + dfs(k, d-1, i+1, cache));
        }
        
        // but now we're also updating the cache the first time we calculate this
        return cache[day][pos] = min;
    }
}
