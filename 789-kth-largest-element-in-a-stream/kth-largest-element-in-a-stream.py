class KthLargest:

    def __init__(self, k: int, nums: List[int]):
       self.k = k
       self.minheap = nums
       heapq.heapify(self.minheap)

    def add(self, val: int) -> int:
        # add new score
        heapq.heappush(self.minheap, val)
        # pop out unnecessary scores
        while len(self.minheap) > self.k:
            heapq.heappop(self.minheap)
        return self.minheap[-self.k]


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)