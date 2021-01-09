class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
       vector<int> rez;
      
        if(matrix.empty()) {
        return rez;
       }
        
      int l=0,r=matrix[0].size(),t=0,b = matrix.size(); 
      
      while(l<r && t<b){
        for(int i = l;i<r;i++) rez.push_back(matrix[t][i]);   // move from left to right
        t++;
        if(t==b) break;
        for(int i = t;i<b;i++) rez.push_back(matrix[i][r-1]);   // move from top to bottom
        r--;
        if(l==r) break;
        for(int i = r-1;i>=l;i--) rez.push_back(matrix[b-1][i]);     // move from right to left
        b--;
        if(t==b) break;
        for(int i = b-1;i>=t;i--) rez.push_back(matrix[i][l]);     //move from bottom to top
        l++;
      }
      return rez;
    }
};
