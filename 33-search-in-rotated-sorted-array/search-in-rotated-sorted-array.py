class Solution:
    def search(self, arr: List[int], target: int) -> int:
        low=0
        high=len(arr) - 1 # 0 based indexing
        # apply binary search concept
        while low <= high:
            mid=(low + (high-low)//2)
            # check the condition
            # low .... mid is sorted and target belongs to that range
            if target == arr[mid]:
                return mid
            elif arr[low] <= arr[mid]:
                if arr[low] <= target <= arr[mid]:
                    high=mid-1
                else:
                    low=mid+1
            else:
                if arr[mid] <= target <= arr[high]:
                    low=mid+1
                else:
                    high=mid-1

        return -1