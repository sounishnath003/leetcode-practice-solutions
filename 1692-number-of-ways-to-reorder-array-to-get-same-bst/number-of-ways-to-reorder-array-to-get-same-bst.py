class Solution:
    def numOfWays(self, nums: List[int]) -> int:
        """
        basically, reorder the array elements (X) no of times, to get the valid BST
        Hint says: use divide and concuque algorithm, looks like i need to punch the permutation NCr
        in my soln.
        """

        MOD=int(1e9+7)
        factorials=[1] * 2 * (len(nums) + 1)
        for i in range(1, len(factorials)):
            factorials[i] = factorials[i-1] * i

        def ncr(n,r):
            # (n+r+1) C (r-1)
            return ((factorials[n + r]) // factorials[n] // factorials[r]) % MOD

        def f(arr):
            # base case:
            if 0 <= len(arr) <= 1:
                return 1

            # as per the question;
            # 1st indexed elem will be the root
            root=arr[0]
            left_childs = [x for x in arr if x < root]
            right_childs = [x for x in arr if x > root]

            return f(left_childs) * f(right_childs) * ncr(len(left_childs), len(right_childs)) # NCr: combinatrics

        return (f(nums) -1) % MOD