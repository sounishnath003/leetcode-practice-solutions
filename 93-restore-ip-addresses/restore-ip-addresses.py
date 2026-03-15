class Solution:
    def restoreIpAddresses(self, s: str) -> list[str]:
        """
        1. Thought: TC: O(N ^ 3 ^ 4)
            1. Recursion + Backtracking
            2. Explore all possibilities, 
                2.1 at every index (start) look for (start + 3) indexes and 
                2.2 check that index could be an valid segment / octate?
                2.3 if YES -> explore next set of indexes (end)
            3. Store all valid segments and return lists of IP addresses..
        """

        n = len(s)
        res, sol = [], []

        def is_valid(segment: str):
            if (
                int(segment) > 255 or 
                len(segment) > 1 and segment[0] == "0"
            ): return False

            return True
        
        def fn(i: int) -> int:
            if i >= n and len(sol) == 4:
                res.append(".".join(sol))
                return

            if len(sol) >= 4 or i >= n: return 

            for j in range(i, min(n, i+3)):
                segment = s[i:j+1]
                if is_valid(segment):
                    sol.append(segment)
                    fn(j+1)
                    # Backtrack to explore other ways
                    sol.pop()

        fn(0)
        return res
