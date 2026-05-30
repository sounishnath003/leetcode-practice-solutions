class Solution:
    def maxFrequency(self, nums: List[int], K: int) -> int:
        """
        - Observations: 
            - Whenever there is nums and K given, the pattern is either 
                `Binary search` or `Sliding Window`.
            - E.g. [1,4,8,13], k = 5
            - I have to convert the elements to some <= X (x may/may not belongs to nums). But if X \
                is outside nums array, the operations is difficult under the budget K.
            - If I pick 13 (index=3), can we make other numbers (0...3) to 13 under K budget?. Probably \
                we can apply Linear search (TC=O(N)) and find its feasability, if not we will reduce the chosen \
                    index to (index=2)?. Consider the nums is sorted, Can we apply `Binary Search`?
            - Binary Search Approach: TC: O(N * LogW * K) # K is the inner [window mid...target_index]
        """
        nums.sort() # sorting the nums
        gmax = 0 # stores the maximum possible frequency achieved

        prefix_sum = [nums[0]]; 
        for num in nums[1:]: 
            prefix_sum.append(prefix_sum[-1] + num)
        
        def query(low:int, high:int) -> int:
            if low == 0: return prefix_sum[high]
            return prefix_sum[high] - prefix_sum[low - 1]

        def binary_search(target_index: int) -> int:
            target = nums[target_index]
            low, high = 0, target_index
            # trying to find the valid window where the required operations is under the budget K?
            ans = 0
            while low <= high:
                mid = (low + high) // 2
                window = target_index - mid + 1
                # window_sum = sum(nums[mid : target_index + 1]) # Costly: O(K)
                window_sum = query(mid, target_index) # Quick: O(1)
                modified_sum = window * target # cause I have modified all elements to the target element
                operations = modified_sum - window_sum
                if operations > K: # ops is over than the budget K?
                    low = mid + 1 # shrink the window?
                else:
                    ans = window
                    high = mid - 1

            return ans

        for i, num in enumerate(nums):
            # considering the target number is NUM, try to modify the elements to target
            # check the frequency, update if necessary....
            freqs = binary_search(target_index=i)
            gmax = max(gmax, freqs)

        return gmax
