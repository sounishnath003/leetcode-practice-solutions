class Solution:
    def maxKelements(self, nums: List[int], K: int) -> int:
        # TC: O(nLogN + KLogK) ; SC: O(N)
        # put all elements into a max heap
        # pop () from heap and add it in score, num / 3 and agin push into heap
        # return result after K ops.

        pq = [-num for num in nums]
        heapq.heapify(pq)

        score = 0
        for _ in range(K):
            num = -heapq.heappop(pq)
            score += num
            heapq.heappush(pq, -(math.ceil(num / 3)))

        return score