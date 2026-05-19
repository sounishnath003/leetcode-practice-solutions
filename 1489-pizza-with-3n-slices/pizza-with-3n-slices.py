class Solution:
    def maxSizeSlices(self, slices: List[int]) -> int:
        choose = len(slices) // 3
        def fnn(slices):
            n = len(slices)

            @lru_cache
            def fn(i:int, remaining:int) -> int:
                if remaining == 0: return 0
                if i >= n: return float("-inf")

                op1 = fn(i+1,remaining)
                op2 = slices[i] + fn(i+2, remaining-1)

                return max(op1,op2,0)

            return fn(0, choose)

        part1, part2 = slices[:-1], slices[1:]
        return max(fnn(part1), fnn(part2))