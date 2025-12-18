class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n=len(nums)
        nat_sum=n*(n+1) // 2
        total = sum(nums)

        print(f"{nat_sum=}, {total=}, {total-nat_sum=}")

        return nat_sum - total