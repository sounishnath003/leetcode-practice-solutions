MAX_LIMIT=int(1e8)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        def find_minimum_rotated_arr(arr):
            global MAX_LIMIT
            low=0
            high=len(arr)-1

            gmin=MAX_LIMIT

            while low <= high:
                mid = low + (high-low)//2
                if arr[low] <= arr[high]:
                    gmin=min(gmin,arr[low])
                    break

                if arr[low] <= arr[mid]:
                    gmin=min(gmin, arr[low])
                    low=mid+1
                else:
                    gmin=min(gmin, arr[mid])
                    high=mid-1

            return gmin

        return find_minimum_rotated_arr(nums)