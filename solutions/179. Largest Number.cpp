class Solution {
public:
    string largestNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end(), [&](const int a, const int b) {
        string x = to_string(a) + to_string(b) ;
        string y = to_string(b) + to_string(a);
        return (x > y) ? 1 : 0 ;
    });
        if(nums[0] == 0){ return "0" ; }
        string s = "";
        for(auto &&x : nums) { s += to_string(x) ; }
        return s ;
    }
};
