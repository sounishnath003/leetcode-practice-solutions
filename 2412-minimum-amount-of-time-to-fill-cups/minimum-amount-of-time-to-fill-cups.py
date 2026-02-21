class Solution:
    def fillCups(self, amount: List[int]) -> int:
        op1 = max(amount)
        op2 = math.ceil( sum(amount) / 2 )
        return max(op1,  op2)