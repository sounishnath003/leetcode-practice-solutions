class Solution {
public:
    int search(vector<int>& nums, int target) {
    int n = nums.size();
    if(n == 0){
        return -1;
    }
    int low = 0, high = n-1;
    int firstel = nums[0];
    while(low <= high)
    {
        int mid = low + (high-low)/2;
        int value = nums[mid];
        if(target == value){
            return mid;
        }
        int am_big = value >= firstel;
        int target_bg = target >= firstel;
        if(am_big == target_bg) {
            if(value < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }else {
            if(am_big) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
    }
        return -1;
    }
};
