class Solution:
    def trailingZeroes(self, n: int) -> int:
        # any number to be a 0 it must be divisable my 5 and its 5x
        cnt = 0
        five = 5
        while five <= n:
            cnt += (n // five)
            if (n//five) == 0:
                break
            five = five * 5
		
        return cnt 