class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        INF = 10**20
        def build_graph_fn():
            graph = defaultdict(list) # string -> [(string, cost)]]
            for i in range(len(original)):
                sword, tword = original[i], changed[i]
                graph[sword].append((tword, cost[i]))
            return graph

        graph = build_graph_fn()
        valid_lengths= sorted(list(set(list(map(len, original)))))

        def dijsktra(s: str, t: str) -> int:
            pq = [(0, s)] # source word , cost
            dist = {s: 0} # word: cost (hshmap)

            while pq:
                wcost, word = heapq.heappop(pq)
                if word == t:
                    break
                # something here??
                for nword, cost in graph[word]:
                    nncost = wcost + cost
                    # if nword not exist in dist hash map
                    if dist.get(nword, INF) > nncost:
                        dist[nword] = nncost
                        heapq.heappush(pq, (nncost, nword))

            final_cost = dist.get(t, INF)
            return final_cost

        @lru_cache(None)
        def fn(i) -> int:
            # you reached the last position of target word
            # you got the final destination
            if i == len(target):
                return 0

            min_cost = INF
            if (source[i] == target[i]):
                min_cost = min(min_cost, fn(i+1))

            # check for all valid lengths
            for length in valid_lengths:
                if i + length > len(source):
                    break
                # you have an options to check possibilities
                src_substr = source[i:i+length]
                tar_substr = target[i:i+length]

                # check target substring present in graph or not
                # if not present skip that shit
                if src_substr not in graph:
                    continue
                hidden_cost = dijsktra(src_substr, tar_substr)
                min_cost = min(min_cost, hidden_cost + fn(i+length))

            return min_cost

        cost = fn(0)
        return -1 if cost >= INF else cost
 