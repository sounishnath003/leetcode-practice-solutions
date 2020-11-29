class Solution {
public:
    int firstUniqChar(string s) {
//         map<char, int> cache;
        
//         for(auto && x : s){
//             cache[x]++;
//         }
        
//         for(auto && x : s){
//             if(cache[x] == 1){
//                 return distance(s.begin(), find(s.begin(), s.end(), x));
//             }
//         }
//         return -1;
        
        // -1 indicates that there are no occurences of char.
        int count_chars[26] = {[0 ... 25] = -1};
        for (int i=0; i<s.size(); i++) {
            char c = s[i];
            int val = count_chars[s[i] - 'a'];
            if (val == -1) count_chars[c - 'a'] = i;
            // -2 indicates that there are more than one occurence of char.
            else if (val != -2) count_chars[c - 'a'] = -2;
        }
        int return_index = INT_MAX;
        for (int i=0; i<26; i++) {
            if (count_chars[i] >= 0) {
                // Get the lowest index for a char that occurs only once.
                return_index = min(return_index, count_chars[i]);
            }
        }
        if (return_index != INT_MAX) return return_index;
        return -1;
    }
        
    }
};
