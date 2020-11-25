class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
       vector<int> ans;
        map<int, int> cache;
        for(auto && x : nums1){cache[x]++ ;}
        for(auto &&x  : nums2){
            if(cache.find(x) != cache.end()){
                if(cache[x] == 0){continue;}
                else {ans.push_back(x);}
                cache[x]--;
            }
        }
        return ans;
    }
};
