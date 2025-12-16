class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        def kth_element_two_array(nums1, nums2, k):
            m, n = len(nums1), len(nums2)

            # Ensure nums1 is the smaller array
            if m > n:
                return kth_element_two_array(nums2, nums1, k)

            # Edge guard (optional but good practice)
            if k < 1 or k > m + n:
                return -1

            low = max(0, k - n)
            high = min(k, m)

            while low <= high:
                mid1 = (low + high) // 2
                mid2 = k - mid1

                l1 = nums1[mid1 - 1] if mid1 > 0 else float("-inf")
                l2 = nums2[mid2 - 1] if mid2 > 0 else float("-inf")

                r1 = nums1[mid1] if mid1 < m else float("inf")
                r2 = nums2[mid2] if mid2 < n else float("inf")

                if l1 <= r2 and l2 <= r1:
                    return max(l1, l2)
                elif l1 > r2:
                    high = mid1 - 1
                else:
                    low = mid1 + 1

            return -1

        m=len(nums1)
        n=len(nums2)
        total = (n+m)

        if total % 2 == 1:
            median = total // 2 +1
            return kth_element_two_array(nums1,nums2,median)
        
        median1=(total // 2)
        median2 = median1+1

        a=kth_element_two_array(nums1,nums2,median1)
        b=kth_element_two_array(nums1,nums2,median2)

        return (a+b)/2