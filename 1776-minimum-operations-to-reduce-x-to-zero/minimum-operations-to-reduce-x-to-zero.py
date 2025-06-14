class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        """
        In one operation, 
        1) you can either remove the leftmost or the rightmost element from the array nums 
        2) and subtract its value from x.

        ---
        1) recursion use korte para jabe. but it would be exponential 2**n solution
        2) but, we can also use the prefix or suffix sum to determine the action
        3) the caveat is, we need some combination of left and right side or any one side elements
        4) this could be hard part .... requires some mathematics soln.

        5) we can find TOTAL_SUM - X = target subarray sum
        -----
        ALGO: find the sub array window target sum to (total_sum - x) only.
        """

        target=sum(nums) - x
        current_sum=0
        max_window=-1 # find the maximum window of target sum
        # using the TWO pointer technique for finding the max window subarray sum targets to TARGET SUM

        # left pointer
        start_index=0

        for end in range(len(nums)):
            # add the element into the current sum variable
            current_sum += nums[end]
            # update the start index and current sum bigger than the target sum
            # adjust the following things
            while start_index <= end and current_sum > target:
                # decrese the current sum
                current_sum -= nums[start_index]
                # increment the start pointer
                start_index += 1

            # check if you hit the target sum
            if current_sum == target:
                window_length=(end - start_index + 1)
                max_window=max(max_window, window_length)
                # break

        return -1 if max_window == -1 else len(nums) - max_window
        