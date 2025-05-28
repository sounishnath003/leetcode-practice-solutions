class Solution:
    def splitArray(self, arr: List[int], k: int) -> int:
        """
        talking about "minimize the maximum sum" -> binary search problem
        ....... find the ranges ....
        low =min(arr)
        max=sum(arr)
        ...sum... into k splits
        """

        low = min(arr)
        high = sum(arr)
        ans=high

        def check_if_we_can_make_atleast_sum_into_k_split(mid):
            split=1
            total=0
            for elem in arr:
                if elem > mid: return False
                if total + elem > mid:
                    split +=1
                    total = elem
                else:
                    total += elem
            # check if we can able to make
            # exactly K splits
            return split <= k


        while low <= high:
            atleast_sum=(low+high)//2
            if check_if_we_can_make_atleast_sum_into_k_split(atleast_sum):
                ans=atleast_sum
                high=atleast_sum-1
            else:
                low=atleast_sum+1

        return ans