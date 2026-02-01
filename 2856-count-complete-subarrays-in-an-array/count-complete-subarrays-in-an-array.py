class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        n = len(nums)
        distinct_elements = len(set(nums))
        
        # Bruteforce solution
        """
        count = 0 
        for i in range(n):
            for j in range(i,n):
                subarr = set(nums[i:j+1])
                if len(subarr) == distinct_elements:
                    count += 1

        return count
        """

        def atMostK(nums, K):
            freq = defaultdict(int)
            start = 0
            res = 0

            for end, x in enumerate(nums):
                freq[x] += 1

                while len(freq) > K:
                    freq[nums[start]] -= 1
                    if freq[nums[start]] == 0:
                        del freq[nums[start]]
                    start += 1

                res += end - start + 1

            return res


        # find the total subarray count with K distinct integers
        # formula (end - start + 1), gives at most K distinct elemnts
        # in question: we need to known EXCATLY K distinct elemnts
        return atMostK(nums, distinct_elements) - atMostK(nums, distinct_elements-1)