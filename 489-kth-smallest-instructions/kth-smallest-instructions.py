import math

class Solution:
    def kthSmallestPath(self, destination: List[int], k: int) -> str:
        r, c = destination[0], destination[1]
        
        # total number of 'H' moves remaining
        h_moves = c
        # total number of 'V' moves remaining
        v_moves = r
        
        result = []
        
        for i in range(r + c):
            # Calculate the number of paths that start with 'H'
            # We have h_moves - 1 horizontal moves and v_moves vertical moves left
            # Total moves remaining = (h_moves - 1) + v_moves
            # We need to choose (h_moves - 1) horizontal spots out of this total
            # The number of such paths is C(h_moves - 1 + v_moves, h_moves - 1)
            
            if h_moves > 0:
                # number of paths starting with 'H'
                h_paths = math.comb(h_moves - 1 + v_moves, h_moves - 1)
            else:
                h_paths = 0

            # If k is less than or equal to the number of paths starting with 'H',
            # it means the kth smallest path must start with 'H'.
            if k <= h_paths:
                result.append('H')
                h_moves -= 1
            else:
                # The kth path must start with 'V'.
                # We skip all paths that start with 'H'.
                result.append('V')
                k -= h_paths
                v_moves -= 1
        
        return "".join(result)


    def slow_but_working():
        paths=list()

        def func(row,col,drow,dcol,path):
            nonlocal paths

            if row>drow or col>dcol:
                return None
            if row==drow and col==dcol:
                return path

            # go H
            hpath=func(row,col+1,drow,dcol,path+"H")
            # go V
            vpath=func(row+1,col,drow,dcol,path+"V")

            if hpath is not None:
                paths.append(hpath)

            if vpath is not None:
                paths.append(vpath)

        # this will get me all the paths
        func(0,0,destination[0],destination[1],"")

        paths.sort()
        return paths[k-1]