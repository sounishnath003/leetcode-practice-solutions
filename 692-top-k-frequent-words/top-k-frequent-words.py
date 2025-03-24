import heapq
from collections import defaultdict
from typing import List

class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        # we need to only keep the K frequent words and return the answer
        # to store the frequency we can use a map
        frequency_map = defaultdict(int)
        # iterate on the all the words
        for word in words:
            frequency_map[word] += 1

        # we need to the have a priority queue
        # which will be holding the K most frequent words
        # we can have a min heap and when size > K
        # remove/pop the elem out of pq
        pq = []  # (count, word)
        # process the key and value one by one from the frequency_map:
        for word, count in frequency_map.items():
            heapq.heappush(pq, (-count, word))  # Negate count for max-heap behavior

        result = []
        for _ in range(k):
            count, word = heapq.heappop(pq)
            result.append(word)

        return result