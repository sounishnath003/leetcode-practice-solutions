class MedianFinder:

    def __init__(self):
        self.maxheap=[]
        self.minheap=[]
        

    def addNum(self, num: int) -> None:
        # i always try to put into maxheap (left) pq
        if len(self.maxheap) == 0 or num <= -self.maxheap[0]:
            heapq.heappush(self.maxheap, -num)
        else:
            heapq.heappush(self.minheap, num)

        # if the size differs by 1 then pop and put
        if len(self.maxheap) > len(self.minheap) + 1:
            heapq.heappush(self.minheap, -heapq.heappop(self.maxheap))
        elif len(self.minheap) > len(self.maxheap):
            heapq.heappush(self.maxheap, -heapq.heappop(self.minheap))
            
    def findMedian(self) -> float:
        total_length=len(self.minheap) + len(self.maxheap)
        if total_length % 2 == 0:
            return (-self.maxheap[0] + self.minheap[0])/2.0
            
        return -self.maxheap[0]