class Solution {
    string vowels = "aeiou";
public:
    int easyMathSolution(int n) {
        return ((n+4)*(n+3)*(n+2)*(n)) / 24
    }
    int countVowelStrings(int n) {
        int ans = 0;
        for (char x : vowels ) {
            ans += dfs(x, n-1);
        }
        return ans;
    }
    int dfs(char lastvowel, int n) {
        if (n==0) {
            return 1;
        }
        int ans=0;
        for (char vowel : vowels) {
            if (vowel >= lastvowel) 
                ans+=dfs(vowel, n-1);
        }
        return ans;
    }
};
