class Solution {
    private int MOD=1000000007;
    Map<String, Integer> cache=new HashMap<>();
    
    public int countPartitions(int[] nums, int k) {
        /**
        this clealy seems to be a subsequence sort-of problem
        you can pick / un-pick
        
        f(i) --> f(i+1, sum + arr[i])
        **/
        
        if (tsum(nums) / 2 < k) return 0;
        
        int wrongPartitions=exploreAllPartitions(nums,0,k,0);
        int totalPartitions=(int) (Math.pow(2, nums.length) % MOD); 
        
        int goodPartitions=(totalPartitions-2*wrongPartitions) + MOD;
        
        
        return goodPartitions % MOD;
    }
    
    public int exploreAllPartitions(int[] nums, int currIndex, int k, int sum) {
        // do the subsequecing....
        
        if (currIndex >= nums.length) {
            return sum < k ? 1 : 0;
        }
        
        String key=currIndex + "#" + sum;
        if (cache.containsKey(key)) return cache.get(key);
        
        // pick
        int p1=0; int p2=0;
        if (sum + nums[currIndex] < k) {
            p1=exploreAllPartitions(nums,currIndex+1,k,sum+nums[currIndex]) % MOD;
        }
        // un pick
        p2=exploreAllPartitions(nums, currIndex+1,k,sum) % MOD;
        
        cache.put(key,  (p1+p2) % MOD);
        return cache.get(key);
    }
    
    private int tsum(int[] arr) {
        int x=0;
        for (int xx : arr) x = (x + (xx % MOD) ) % MOD;
        return x % MOD;
    }
}
