class Solution {
public:
    int lengthOfLongestSubstring(string s) {
       if (s.empty()){return 0;}
​
        map<int, int> cache ;
        int st = 0, len=1;
        for (int end = 0; end < (int) s.length(); end++) {
            char ch = s[end];
            if (cache.count(ch) && st <= cache[ch]) {
                st = cache[ch]+1;
            }
            len = max(len, end-st+1);
            cache[ch]=end;
        }
​
        return len;
    }
};
