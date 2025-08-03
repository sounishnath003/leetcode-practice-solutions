class Solution:
    def longestOnes(self, nums: List[int], k:int) -> int:
        """returns longest windows ones"""
        # ret. max consecutive ones. if you can flip atmost k zeros.
        # get the length of the arr
        n=len(nums)
        # i can count zeros in my current iteration
        # whenever i encountered more than K zeros,
        # shrink the window -> get the length of the window -> zero-- -> increment start pointer
        # calc. the max(curr.window, global.window)
        # return the global.window

        zero=0
        start=0
        max_window=0

        for end, elem in enumerate(nums):
            if elem==0:
                zero+=1

            while zero > k:
                if nums[start] == 0:
                    zero-=1
                start+=1
            
            window=(end-start+1)
            max_window=max(max_window, window)

        return max_window
        
    def longestOnes2(self, nums: List[int], k: int) -> int:
        """
        what if?
        1) count zeros in your iteration 0...n
        2) when countOfZeros > k:
            2.1) try to shrink the window and 
            2.2) calc the window length
            2.3) decrement the countOfZeros
            2.4) increment the start pointer
        3) maintain a global window and update it
        4) return the global window as answer
        """

        # get the length of arr
        n=len(nums)
        # define the vars
        start=0
        zero_count=0
        gans=0

        # iterate over the window
        for end, elem in enumerate(nums):
            # check if elem == 0
            if elem == 0:
                # incr zero count
                zero_count +=1
            # check if you surpassed the K
            while zero_count > k:
                # shirnk the window and update the incr
                # in case it is zero
                if nums[start]==0:
                    zero_count -= 1
                start += 1
            # just update the global window ans
            # as per the start .... end window
            gans = max(gans, end-start + 1) # added (1) - 0 based indexing
            
        return gans