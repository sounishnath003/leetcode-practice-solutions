class Solution {
public:
    int titleToNumber(string s) {
        long long int n=0;
        for(auto c: s){
            n = (n * 26) + (int)(c - 'A' + 1);
        }
        return n;
    }
};
