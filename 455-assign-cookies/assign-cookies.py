# LC: 455
# https://leetcode.com/problems/assign-cookies/description/
class Solution:
    def findContentChildren(self, g: list[int], s: list[int]) -> int:
        """
        1. Optimized:
            1. Think: Greedily; I will fulfil the least desired children first.
            2. Sort the Greed array and Size Array
            3. Keep assigning the cookies if greedy[child] <= size[cookie]
        """

        if not len(s): return 0

        # Sort the greedy and cookie size arrays
        g.sort(); s.sort()

        children_idx, cookie_idx = 0, 0

        while children_idx < len(g) and cookie_idx < len(s):
            if g[children_idx] <= s[cookie_idx]:
                children_idx += 1
            
            cookie_idx += 1

        return children_idx
