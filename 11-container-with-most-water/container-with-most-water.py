class Solution:
    def maxArea(self, heights):
        # get the length of arr
        n=len(heights)

        left=0
        right=n-1
        
        maxarea=0

        while left < right:
            lh=heights[left]
            rh=heights[right]

            width=right-left
            height=min(lh,rh)
            area=width*height
            maxarea=max(area, maxarea)

            # move the smaller heigh pointer
            if lh==rh:
                left +=1
                right -=1
            elif lh < rh:
                left+=1
            elif rh < lh:
                right-=1


        return maxarea