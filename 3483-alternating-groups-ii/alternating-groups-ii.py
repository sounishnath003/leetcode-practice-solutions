class Solution:
    def numberOfAlternatingGroups(self, nums: List[int], k: int) -> int:
        # TC: O(N x k)
        def slow():
            n=len(nums)
            count=0

            for start in range(n):
                ok=True
                for i in range(start, start + k - 1):
                    if nums[i%n]==nums[(i+1)%n]:
                        ok=False
                        break

                if ok: count +=1

            return count

        # return slow()

        n=len(nums)
        count=0
        window=0
        for i in range(1,2*n):
            if nums[(i-1)%n]!=nums[i%n]:
                window+=1
            else:
                window=1

            if window>=k: count +=1
            if i>=n+k-1: break

        return count