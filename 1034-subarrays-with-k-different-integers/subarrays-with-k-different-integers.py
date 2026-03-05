# LC: 992
# https://leetcode.com/problems/subarrays-with-k-different-integers/

from collections import Counter


class Solution:
    def subarraysWithKDistinct(self, nums: list[int], k: int) -> int:
        """
        1. Native: TC: O(N^2) ; SC: O(K)
            1. Use 2-For Loop, Keep an inner hashmap
            2. Start Incrementing the frequency of inner elements of (for j in range(i,n))
            3. if hashmap count == K: calculate the window of (j - i +1). Update global maximum
            4. Return the answer as result.

        2. Optimized: TC: O(N) ; SC: O(K)
            1. Use 2-Pointer technique and Hashmap to store the frequency of elements
            2. if Map.Size > K: shrinnk the window 
            3. Calculate the Window Element. Return Rsult
            4. Return the global maximum
        """

        def fn(K:int):
            n = len(nums)
            mapp = Counter()
            start, subarr_count = 0,0
            # Iterate on the array
            for end in range(n):
                # Put the elem into map
                mapp[nums[end]] += 1
                # Just in case, you passed on the Map.Size > K
                while len(mapp) > K:
                    mapp[nums[start]] -= 1
                    if mapp[nums[start]] == 0: del mapp[nums[start]]
                    start += 1
                window = (end - start + 1)
                subarr_count += window

            return subarr_count

        return fn(k) - fn(k-1)