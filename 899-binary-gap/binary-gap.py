class Solution:
    def binaryGap(self, n: int) -> int:
        binary = bin(n)[2:]
        one_pos = [i for i in range(len(binary)) if binary[i] == '1']
        diffs = [b-a for a,b in zip(one_pos, one_pos[1:])] or [0]
        return max(diffs)