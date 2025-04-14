class Solution:
    def numTeams(self, arr:List[int]) -> int:
        """
        follow the condition like (a[i] < a[j] < a[k]) or (a[i] > a[j] > a[k]) where (i < j < k)
        this trick might work
        ---- # left smaller elems ---- ( captain ) ---- # right bigger elems 
        +
        ---- # left bigger elems ---- ( captain ) ---- # right smaller elems 
        """
        teams=0
        n=len(arr)

        for m in range(1,n - 1):
            left_smaller=0
            # count the left smaller elems
            for i in range(m):
                if arr[i] < arr[m]:
                    left_smaller +=1
            
            right_bigger=0
            for k in range(m+1, n):
                if arr[m] < arr[k]:
                    right_bigger+=1

            teams += (left_smaller * right_bigger)

            left_bigger=m - left_smaller
            right_smaller=n - m - 1 - right_bigger
            teams += (left_bigger * right_smaller)

        return teams
    
    def numTeamsRecursion(self, arr:List[int]) -> int:
        """
        follow the condition like (a[i] < a[j] < a[k]) or (a[i] > a[j] > a[k]) where (i < j < k)
        """
        dp={}
        def f(arr, i):
            if len(arr) == i:
                return 0
            
            if i in dp:
                return dp[i]
            
            # faith
            nottake=f(arr, i+1)
            myteam=0
            for j in range(i+1, len(arr)):
                for k in range(j+1, len(arr)):
                    condition1=(arr[i] < arr[j] < arr[k])
                    condition2=(arr[i] > arr[j] > arr[k])
                    if condition1 or condition2:
                        myteam+=1

            dp[i] = nottake + myteam
        
        return f(arr, 0)
    
# s=Solution()
# print("total teams can be formed: %d" % s.countOfTeams([2,5,3,4,1]))
# print("total teams can be formed: %d" % s.countOfTeams([2,1,3]))
# print("total teams can be formed: %d" % s.countOfTeams([1,2,3,4]))