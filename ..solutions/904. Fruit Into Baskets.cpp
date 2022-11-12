class Solution {
public:
    int totalFruit(vector<int>& trees) {
        if(trees.empty()) {
            return 0;
        }
        int maxfruit = 1;
        unordered_map<int, int> cache;
        int i=0, j=0;
        while(j < (int) trees.size()) {
            if(cache.size() <= 2) {
                cache[trees[j]] = j;
                j++;
            }
            if((int) cache.size() >= 3) {
                int minimum = (int) trees.size() - 1;
                for(auto &&p : cache) {
                    minimum = min(minimum, p.second);
                }
                i = minimum+1;
                cache.erase(trees[minimum]);
            }
            maxfruit = max(maxfruit, j-i);
        }
        return maxfruit;
    }
};
