from math import comb

class Solution:
    def kthSmallestPath(self, destination: List[int], k: int) -> str:
        drow, dcol = destination
        path = ""

        while drow > 0 or dcol > 0:
            if dcol > 0:
                count = comb(drow + dcol - 1, dcol - 1)  # # of paths if we go 'H' now
            else:
                count = 0

            if k <= count:
                path += "H"
                dcol -= 1
            else:
                path += "V"
                k -= count
                drow -= 1

        return path


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