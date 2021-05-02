class Solution {
    int R, C;
public:
    void sort(vector<vector<int>> &mat, int row, int col) {
        vector<int> temp;
        int r = row, c = col;
        while(r < R && c < C) {
            temp.push_back(mat[r++][c++]);
        }
        std::sort(temp.rbegin(), temp.rend());
        r = row, c = col;
        while (r < R && c < C) {
            mat[r++][c++] = temp.back();
            temp.pop_back();
        }
    }
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        if(mat.empty()){
            return {{}};
        }
        R = mat.size();
        C = mat[0].size();
        for (int col = 0; col < C; col++) {
            sort(mat,0,col);
        }
        for (int row = 1; row < R; row++) {
            sort(mat,row,0);
        }
        return mat;
    }
};
