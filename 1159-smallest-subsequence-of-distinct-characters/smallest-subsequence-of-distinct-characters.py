# LC: 316, 1081
# https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/description/
class Solution:
    def smallestSubsequence(self, s: str) -> str:
        last_position_map = {char: i for i, char in enumerate(s)}
        used = set()
        res = []

        for i, char in enumerate(s):
            if char not in used:
                # check conditions:
                # char < res[-1] -> then pop res[-1]
                # current.index < last_pos_map[char] (means, i can still include later) -> then pop res[-1]
                while res and char < res[-1] and i < last_position_map[res[-1]]:
                    poped_char = res.pop()
                    used.discard(poped_char)

                res.append(char)
                used.add(char)

        return "".join(res)