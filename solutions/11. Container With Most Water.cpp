class Solution {
public:
    #define fo(i, k, n) for(int i = k; i < n; i++)
    const int inf = 0x3f3f3f3f;
    
    int maxArea(vector<int>& nums) {
        
        /*
            O(N*N)solutions:
            
            for(i,0,n){
                for(j,i+1,n){
                    minn = min(height[i], height[j]);
                    maxv = max(maxv, minn*(j-i));
                }
            }
            return maxv;
        */
        
        int n = nums.size();
        int maxv = -1 * inf;
        int i = 0, j = n-1;
        while(i < j) {
            int minn = min(nums[i], nums[j]);
            maxv = max(maxv, minn*(j-i));
            if(nums[i]<nums[j]) {
                i++;
            } else {
                j--;
            }
       }
       return maxv;
    }
};
