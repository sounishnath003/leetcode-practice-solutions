# LC: 703
# https://leetcode.com/problems/kth-largest-element-in-a-stream/
import heapq


class KthLargest:
    def __init__(self, K:int, nums: list[int]) -> None:
        self.nums = nums
        self.K = K

        # min heapify them
        heapq.heapify(self.nums)

    def add(self, val: int) -> int:
        heapq.heappush(self.nums, val)
        while len(self.nums) > self.K: heapq.heappop(self.nums)

        return self.nums[0] #heapq.nsmallest(self.K, self.nums)[0]