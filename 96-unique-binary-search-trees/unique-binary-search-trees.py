class Solution:
    def numTrees(self, n: int) -> int:
        numTreees = [1] * (n+1)
        for nodes in range(1, n+1):
            trees=0
            for root in range(1,nodes+1):
                leftTrees = numTreees[root-1]
                rightTrees = numTreees[nodes-root]
                trees += (leftTrees * rightTrees) 
            
            numTreees[nodes]=trees

        return numTreees[n]