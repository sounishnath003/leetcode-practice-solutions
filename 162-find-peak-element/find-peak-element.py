class Solution:
    def findPeakElement(self, arr: List[int]) -> int:
        # get the length of the arr
        n=len(arr)
        if n == 1:
            return 0
        # base condition checks 
        # if the 0th or n-1th element is the peak
        if arr[0] > arr[1]:
            return 0
        if n-2 >= 0 and arr[n-1] > arr[n-2]:
            return n-1
        # now we can apply binary search?
        # through the array check if an element is greater than its neighbors
        low=1
        high=n-2
        peak = -1
        while low <= high:
            mid = (low + (high-low)//2)
            # check if the mid element is the peak?
            if arr[mid-1] < arr[mid] and arr[mid] > arr[mid+1]:
                peak=mid
                return peak
            elif arr[mid] > arr[mid-1]:
                low=mid+1
            else:
                high=mid-1

        return peak