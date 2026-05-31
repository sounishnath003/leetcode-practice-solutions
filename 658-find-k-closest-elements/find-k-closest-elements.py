class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # TC: O(LogN + K)
        # find the lowerbound of the array
        right = bisect_left(arr, x)
        left = right - 1

        res = []
        # run a 2-pointer technique and apply the abs() formula
        while k > 0 and left >= 0 and right < len(arr):
            if x - arr[left] <= arr[right] - x:
                res.append(arr[left])
                left -= 1
            else:
                res.append(arr[right])
                right += 1
            k -= 1
        # incase K is left and i exists >= 0
        while k > 0 and left >= 0:
            res.append(arr[left])
            left -= 1
            k -= 1
        # incase K is left and j < len(arr)
        while k > 0 and right < len(arr):
            res.append(arr[right])
            right += 1
            k -= 1

        return sorted(res)