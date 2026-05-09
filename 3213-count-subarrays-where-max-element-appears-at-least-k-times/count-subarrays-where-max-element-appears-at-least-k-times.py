class Solution:
    def countSubarrays(self, nums: list[int], k: int) -> int:
        max_element = max(nums)
        start,subarr = 0,0
        seen = 0
        
        for end in range(len(nums)):
                if nums[end] == max_element:
                    seen += 1
                while seen == k:
                    if nums[start] == max_element:
                        seen -= 1
                    start += 1
                subarr += start
                        
        return subarr