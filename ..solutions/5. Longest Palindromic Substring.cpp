class Solution {
public:
    string longestPalindrome(string s) {
        int start = 0;
        if (s.empty()) {
            return nullptr;
        }
        if (s.length() == 1) {
            return s;
        }
        int maxlen = 1;
        int n = (int) s.length();
        for (int i = 0; i < n-1; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n) {
                if (s[l]==s[r]) {
                    l--, r++;
                }else {
                    break;
                }
            }
            int len = r-l-1;
            if (maxlen < len) {
                maxlen = len;
                start = l+1;
            }
        }
        for (int i = 0; i < n-1; i++) {
            int l = i, r = i+1;
            while (l >= 0 && r < n) {
                if (s[l]==s[r]) {
                    l--, r++;
                }else {
                    break;
                }
            }
            int len = r-l-1;
            if (maxlen < len) {
                maxlen = len;
                start = l+1;
            }
        }
​
        return s.substr(start, maxlen);
    }
};
