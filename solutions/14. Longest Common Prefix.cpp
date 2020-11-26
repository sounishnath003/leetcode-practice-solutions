class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if(strs.size() == 0)   {
            return "";
        }
        string prefix = strs[0];
        for(int i = 1; i < (int) strs.size(); i++){
            while(strs[i].find_first_of(prefix) == string::npos){
                prefix = string(prefix.substr(0, prefix.length() - 1));
            }
        }
        return prefix;
    }
};
