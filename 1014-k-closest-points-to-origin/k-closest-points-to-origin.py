class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        # max heap
        pq = []

        for i, (x,y) in enumerate(points):    
            dist = x**2 + y**2
            heapq.heappush(pq, (-dist, i))
            if len(pq) > k: heapq.heappop(pq)

        return list(map(lambda pair: points[pair[1]], pq))