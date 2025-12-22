class Solution:
    def fourSum(self, nums: List[int], K: int) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        res = set()
        for i in range(n):
            if i > 0 and nums[i-1] == nums[i]:
                continue
            for j in range(i+1, n):
                if j > i+1 and nums[j-1] == nums[j]:
                    continue
                left = j+1
                right = n-1
                while left < right:
                    total = nums[i] + nums[j] + nums[left] + nums[right]
                    if total == K:
                        quad = (nums[i], nums[j], nums[left], nums[right])
                        res.add(quad)
                        left += 1
                        right -= 1
                        while left < right and nums[left] == nums[left-1]:
                            left += 1
                        while left < right and nums[right] == nums[right+1]:
                            right -= 1
                    elif total < K:
                        left += 1
                    else:
                        right -= 1
        return [list(quad) for quad in sorted(res)] 