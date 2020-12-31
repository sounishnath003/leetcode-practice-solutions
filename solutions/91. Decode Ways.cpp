class Solution {
    vector<int> dp;
    int go(string &s, int curindex) {
        if (s[curindex] == '0' ) {
            return 0;
        }
        if (curindex >= s.length()) {
            return 1;
        }
        if (dp[curindex]!=-1){
            return dp[curindex];
        }
        int newWays = go(s, curindex+1);
        if (curindex+2 <= s.length() && stoi(s.substr(curindex,2)) <= 26 ) {
            newWays += go(s,curindex+2);
        }
        return dp[curindex] = newWays;
    }
    
public:
    int numDecodings(string s) {
        dp.resize((int)s.length(), -1);
        return go(s,0);
    }
};
