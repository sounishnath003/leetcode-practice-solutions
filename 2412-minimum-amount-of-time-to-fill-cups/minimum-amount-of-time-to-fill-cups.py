class Solution:
    def fillCups(self, amount: List[int]) -> int:
        op1 = max(amount) # aktai cup borte parbi jodi baki kono input na thake
        op2 = math.ceil( sum(amount) / 2 ) # Oikick niyom
        return max(op1,  op2)