class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        unordered_map<int, int> cache;
        for (int x : nums)
           cache[x]++;
        
        int ans=0;
        for(pair<int, int> const &pp : cache) {
            int key = pp.first;
            int compp = k - key;
            if (cache.count(key) && cache.count(compp)) {
                // 1 4
                if(key != compp) { // meaning they are distinct
                    ans += min(cache[key], cache[compp]); // pair<> found!
                    cache[key]=0, cache[compp]=0;
                } else {
                    ans += floor(cache[key]/2);
                    cache[key]=0;
                }
            }
        }
        return ans;
    }
};
