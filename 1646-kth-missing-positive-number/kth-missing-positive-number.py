from typing import List

class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        low, high = 0, len(arr) - 1
        while low <= high:
            # get possible mid index
            mid = (low + high) // 2
            # check the count of missing numbers...
            count_of_missing = arr[mid] - (mid + 1)
            # check the # missing < k: move thr low = 1
            if count_of_missing < k:
                low = mid + 1
            else:
                high = mid - 1
                
        return low + k
    