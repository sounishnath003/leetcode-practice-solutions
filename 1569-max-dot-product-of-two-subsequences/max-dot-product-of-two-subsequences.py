class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        n = len(nums1)
        m = len(nums2)
        
        # Initialize dp array with negative infinity
        dp = [[float("-inf") for _ in range(m)] for _ in range(n)]
        
        # Base case - first element
        dp[0][0] = nums1[0] * nums2[0]
        
        # Fill dp table
        for i in range(n):
            for j in range(m):
                curr_prod = nums1[i] * nums2[j]
                # Take current product and add previous max
                op1 = curr_prod + (dp[i-1][j-1] if i > 0 and j > 0 else 0)
                # Take max of:
                # 1. Current product alone
                # 2. Current product + previous max
                # 3. Skip current element from nums1
                # 4. Skip current element from nums2
                dp[i][j] = max(
                    curr_prod,
                    op1,
                    dp[i-1][j] if i > 0 else float('-inf'),
                    dp[i][j-1] if j > 0 else float('-inf')
                )
        
        return dp[n-1][m-1]
    
    def maxDotProduct2(self, nums1: List[int], nums2: List[int]) -> int:
        # can we use recursion? yes we surely can
        dp = {}
        def f(arr1, arr2, i, j):
            if i < 0 or j < 0:
                return float('-inf')
            
            # thought this will a base case
            # anyway we are calculating it below (op4)
            # if i == 0 or j == 0:
            #     return arr1[i] * arr2[j]

            if (i,j) in dp:
                return dp[(i,j)]

            op1=(arr1[i] * arr2[j]) + f(arr1, arr2, i-1, j-1)
            op2=f(arr1, arr2, i-1, j)
            op3=f(arr1, arr2, i, j-1)
            op4=(arr1[i] * arr2[j])

            dp[(i,j)] = max(op1,op2,op3,op4)
            return dp[(i,j)]

        n=len(nums1)
        m=len(nums2)

        return f(nums1, nums2, n-1, m-1)