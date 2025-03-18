class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        results=[]

        pq=[] # (val, index) # max heap
        for index, val in enumerate(nums):
            # remove the elems which indexes are invalid, not in range K
            while pq and pq[0][1] < index-k+1:
                heapq.heappop(pq)
            # remove the vals which are smaller than the current
            while pq and -pq[-1][0] < val:
                pq.pop(len(pq)-1)
                
            heapq.heappush(pq, (-val, index))
            if index >= k-1:
                results.append(-pq[0][0])

        return results