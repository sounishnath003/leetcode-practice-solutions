class Solution {
public:
    vector<string> mapps = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
    
    vector<string> letterCombinations(string digits) {
        vector<string> answers;
        if(digits.length() == 0 || digits.empty()) {
            return answers;
        }
        dfs(answers, digits, "", 0);
        return answers;
    }
    
    void dfs(vector<string>& answers, string digits, string curr, int index) {
        if(digits.length() == index) {
            answers.push_back(curr);
            return ;
        }
        string letters = mapps[digits[index] - '0'];
        for(auto letter : letters) {
            f(answers, digits, curr+letter, index+1);
        }
    }
};
