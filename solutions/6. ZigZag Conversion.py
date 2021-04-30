class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows <= 1:
            return s
        
        rows = [[] for i in range(numRows)]
        currow = 0
        delta  = -1
        for ch in s:
            rows[currow].append(ch)
            if (currow == 0 or currow == (numRows - 1)):
                delta = delta * -1
            currow += delta
            
        for i in range(len(rows)):
            rows[i] = ''.join(rows[i])
            
        return ''.join(rows)
    
        
