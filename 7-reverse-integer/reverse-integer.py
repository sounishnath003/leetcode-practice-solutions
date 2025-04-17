
class Solution:
    def reverse(self, x: int) -> int:
        MIN=-1 * (2**31)
        MAX=(2**31) - 1
        
        def check_overflow(x):
            return True if x < MIN or x > MAX else False
        
        if check_overflow(x):
            return 0
        
        is_negetive=x < 0
        num=0
        if is_negetive:
            x=abs(x)
        
        while x > 0:
            num = num * 10 + (x % 10)
            if check_overflow(num):
                return 0
            x=x//10
            
        num=-1 * num if is_negetive else num
        return 0 if check_overflow(num) else num
            
        