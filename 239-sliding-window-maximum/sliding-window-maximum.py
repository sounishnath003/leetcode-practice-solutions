class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:        
        results = []
        deq = deque()
        
        for i, num in enumerate(nums):
            # Remove elements not within the sliding window
            if deq and deq[0] < i - k + 1:
                deq.popleft()
            
            # Remove elements smaller than the current element
            while deq and nums[deq[-1]] < num:
                deq.pop()
            
            deq.append(i)
            
            # Append the maximum element of the current window
            if i >= k - 1:
                results.append(nums[deq[0]])
        
        return results
        
    def maxSlidingWindow2(self, nums: List[int], k: int) -> List[int]:
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