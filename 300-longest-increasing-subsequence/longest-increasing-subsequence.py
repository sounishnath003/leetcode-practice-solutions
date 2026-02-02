class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [1] * (n)
        for i in range(1,n):
            for j in range(i):
                if nums[i] > nums[j] and dp[j] + 1 > dp[i]:
                    dp[i] = dp[j] + 1

        # return max(dp)

        # we can apply binray search also to find the correct positions of the elemnts
        temp = []
        for num in nums:
            idx = bisect.bisect_left(temp, num)
            if idx == len(temp):
                temp.append(num)
            else:
                temp[idx] = num

        return len(temp)
