class Solution {
private:
    std::vector<int> array;
    std::vector<int> arr_copy;
    
public:
    Solution(std::vector<int>& nums):
        array(std::move(nums)),
        arr_copy(std::vector<int> { array.begin(), array.end() }) {}
    
    /** Resets the array to its original configuration and return it. */
    std::vector<int> reset() {
        array = arr_copy;
        arr_copy = std::vector<int> { arr_copy.begin(), arr_copy.end() };
        return arr_copy;
    }
    
    /** Returns a random shuffling of the array. */
    std::vector<int> shuffle() {
        std::mt19937 rng { std::random_device{}() };
        std::shuffle(begin(array), end(array), rng);
        return array;
    }
};
​
/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(nums);
 * vector<int> param_1 = obj->reset();
 * vector<int> param_2 = obj->shuffle();
 */
