class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        set<int> visitedRooms ;
        visitedRooms.insert(0);
​
        stack<int> cacheRooms ;
        cacheRooms.push(0);
        while (cacheRooms.empty()==false) {
            vector<int> roomKeys = rooms[cacheRooms.top()];
            cacheRooms.pop();
            for (int key : roomKeys) {
                if (visitedRooms.count(key)==0) {
                    visitedRooms.insert(key);
                    cacheRooms.push(key);
                }
            }
        }
        return (int) visitedRooms.size() == (int) rooms.size() ;   
    }
};
