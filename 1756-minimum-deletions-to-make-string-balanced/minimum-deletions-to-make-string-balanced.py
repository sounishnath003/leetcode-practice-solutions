class Solution:
    def minimumDeletions(self, s: str) -> int:
        # indexes shows order, but the problem is count
        b = 0
        ans = 0

        for ch in s:
            if ch == 'b':
                b += 1
            else:  # 'a'
                ans = min(ans + 1, b)

        return ans



"""
01234567
aababbab
op1=aaabbb (deleted 2) 
op2=aabbbb (deleted 2)

ans = 2

a = [0,1,3,6]
b = [2,4,5,7]

012345678
bbaaaaabb
op1=aaaaabb (deleted 2 characters)

ans = 2

a=[2,3,4,5,6]
b=[0,1,7,8]
"""