class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
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