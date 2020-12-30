class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        map<char, int>  cache ;
        for (char x : tasks)
            cache[x]++;
        
        priority_queue<int> pq;
        for (pair<int, int> v : cache)
            pq.push(v.second);
        
        int cycles = 0;
        while (!pq.empty()) {
            vector<int> temp; // ith clock cycle in CPU
            for (int cooler = 0; cooler < n + 1; cooler++) {
                if (!pq.empty()){
                    temp.push_back(pq.top());
                    pq.pop();    
                }
            }
            // run again for any task occurs more > 1
            for (int task : temp) {
                if(--task > 0) {
                    pq.push(task);
                }
            }
            
            cycles += (pq.empty()) ? temp.size() : n+1 ;
        }
        
        return cycles;
    }
};
