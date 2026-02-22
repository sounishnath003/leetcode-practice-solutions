from collections import Counter
import heapq

class Solution:
    def reorganizeString(self, s: str) -> str:
        count = Counter(s)
        max_heap = []

        # Build max heap (negative because heapq is min-heap)
        for char, freq in count.items():
            heapq.heappush(max_heap, (-freq, char))

        result = []

        while len(max_heap) > 1:
            freq1, char1 = heapq.heappop(max_heap)
            freq2, char2 = heapq.heappop(max_heap)

            result.append(char1)
            result.append(char2)

            if freq1 + 1 < 0:
                heapq.heappush(max_heap, (freq1 + 1, char1))
            if freq2 + 1 < 0:
                heapq.heappush(max_heap, (freq2 + 1, char2))

        # If one char remains
        if max_heap:
            freq, char = heapq.heappop(max_heap)
            if -freq > 1:
                return ""
            result.append(char)

        return "".join(result)