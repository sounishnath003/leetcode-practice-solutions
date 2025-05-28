class Solution:
    def largestOddNumber(self, num: str) -> str:
        # start backwards and find the numbers
        n=len(num)
        for i in range(n-1, -1, -1):
            digit=int(num[i])
            if digit % 2 == 1:
                return num[:i+1]

        return ""