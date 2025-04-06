class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def func(s,index,curr,res):
            if index == len(s):
                res.append(list(curr))
                return 

            for i in range(index, len(s)):
                t=s[index:i+1]
                if t[:] == t[::-1]:
                    curr.append(t)
                    func(s,i+1,curr,res)
                    curr.pop()
            
        curr=[]
        res=[]
        func(s,0,curr,res)
        return res