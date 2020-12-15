class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
       /* 
         // --> O(NlogN) solution
        for_each(nums.begin(), nums.end(), [&](int &n) {return n = n*n;});
        sort(nums.begin(), nums.end());
        return nums ;
        */
        
        // Quite efficient - O(N) solution
        int n = nums.size() ;
        vector<int> answer(n) ;
        for (int i = 0, j = n-1, k = j; i <= j; k-- ) {
            if( pow(nums[i], 2) > pow(nums[j],2)) {
                answer[k] = nums[i]*nums[i];
                i++ ;
            } else {
                answer[k] = nums[j]*nums[j];
                j-- ;
            }
        }
        return answer ;
    }
};
