class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        set<int> cache ;
        for(auto && x : nums ){
            if(cache.count(x)){
                return true;
            }
                cache.insert(x);
        }
        return false;
    }
};
