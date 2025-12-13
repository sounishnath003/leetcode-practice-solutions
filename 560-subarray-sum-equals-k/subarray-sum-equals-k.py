# LC: 560
class Solution:
    def subarraySum(self, nums: List[int], K: int) -> int:
        prefix_sum = 0
        mapp = defaultdict(int) # <sum, freq>
        
        mapp[0] = 1
        found = 0

        for num in nums:
            prefix_sum += num
            complement = prefix_sum - K
            found += mapp[complement]
            mapp[prefix_sum] +=1

        return found