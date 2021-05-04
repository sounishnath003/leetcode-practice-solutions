class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ans;
        
        for(int row = 0 ; row < numRows; row++) 
        { 
            vector<int> t;
            for(int space = 0; space < (numRows - row); space++)
            { 
                // cout << " " ; 
            
            } 
            int n = 1 ; 
            for(int col = 0; col <= row; col++)
            { 
                t.push_back(n); 
                n = n * (row - col) / (col + 1) ;
            } 
            ans.push_back(t);
        }
        return ans;
    }
};
