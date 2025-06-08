class Solution:
    def minimumSize(self, nums: List[int], maxOperations: int) -> int:
        # minimize maximize ==> binary search problem
        # try to minimize the penalty by breaking the large buckets into smaller chunks and repeat until K is 0

        gmin = float("inf")

        def can_do(penalty):
            """
            1) pick the biggest chunk and break into 1....n/2 pieces
            2) repeat for all
            """
            ops = 0
            for ball in nums:
                if ball > penalty:
                    ops += (ball - 1) // penalty
            return ops <= maxOperations

        low = 1  # minimum penalty
        high = max(nums)  # max penalty

        while low <= high:
            mid = (low + high) // 2
            if can_do(mid):
                high = mid - 1
                gmin = mid
            else:
                low = mid + 1

        return gmin

        return gmin


"""
2 4 8 2
k=4

1) 2 4 2 6 2
2) 2 2 2 2 6 2
3) 2 2 2 2 2 4 2
4) 2 2 2 2 2 2 2 2
"""
