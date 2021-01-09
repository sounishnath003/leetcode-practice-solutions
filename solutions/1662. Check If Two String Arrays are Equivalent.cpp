class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        string s = "", t = "";
        for (string x : word1)
            s += x;
        
        for (string x : word2)
            t += x;
        
        return s==t; 
    }
};
