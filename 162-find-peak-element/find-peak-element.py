class Solution:
    def is_peak(self, arr, mid):
        return (mid-1) >= 0 and (mid+1 < len(arr)) and arr[mid-1] < arr[mid] and arr[mid] > arr[mid+1]

    def findPeakElement(self, arr: List[int]) -> int:
        # get the length
        n=len(arr)
        if n==1:
            return 0
        # check if 0th elem is peak
        if arr[0] > arr[1]:
            return 0
        # check if n-1th elem is peak
        if n-2>=0 and arr[n-1] > arr[n-2]:
            return n-1
        # do the check for 
        # all the idnexes
        low=1
        high=n-2

        while low <= high:
            mid=(low + (high-low)//2)
            if self.is_peak(arr, mid):
                return mid
            elif arr[mid-1] > arr[mid]:
                high=mid-1
            elif arr[mid+1] > arr[mid]:
                low=mid+1

        return -1