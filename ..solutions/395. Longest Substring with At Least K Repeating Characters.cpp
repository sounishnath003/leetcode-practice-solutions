class Solution {
public:
int f(string &s, int lo, int hi, int k){
        if(hi-lo < k){
            return 0;
        }
        vector<int> count(26);
        for(int i = lo; i< hi; i++){
            count[s[i]-'a']++;
        }
        for(int i = lo; i < hi; i++){
            if(count[s[i]-'a'] < k ){
                int j = i+1;
​
                while(j<hi && count[s[j] -'a'] < k){
                    j++;
                }
                return max( f(s, lo, i, k), f(s, j, hi, k) );
            }
        }
        return hi-lo;
}
    
    int longestSubstring(string s, int k) {
        
        return f(s, 0, s.length(), k);
    }
};
