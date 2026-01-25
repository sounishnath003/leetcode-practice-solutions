class Solution:
    def trailingZeroes(self, n: int) -> int:
        # any number to be a 0 it must be divisable my 5 and its 5x
        # TOO MUCH CODE
        cnt = 0
        five = 5
        while five <= n:
            cnt += (n // five)
            if (n//five) == 0:
                break
            five = five * 5
		
        cnt = 0
        while n > 4:
            cnt += int(n / 5)
            n = n // 5
        return cnt