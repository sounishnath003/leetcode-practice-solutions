class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        def max_consecutive_ones_III(arr, k):
            n=len(arr)
            gmax=0
            count=0
            start=0

            for end in range(n):
                e=arr[end]
                if e == 0:
                    # when it is 0, we need to flip to 1
                    count+=1
                while count > k:
                    # we need to backtrack the start back to 0
                    # only if it is 0
                    if arr[start] == 0:
                        count -=1
                    start+=1

                window_length=end-start+1
                gmax=max(gmax, window_length)

            return gmax

        return max_consecutive_ones_III(nums,k)