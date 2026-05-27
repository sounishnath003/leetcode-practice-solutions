"""
1. Store all points in a set for $O(1)$ lookup.
2. Pick two points, $P_1(x_1, y_1)$ and $P_2(x_2, y_2)$.
3. Check if they can be a diagonal: They must have different $x$ and different $y$ values.
4. Check for the other two corners: Does $(x_1, y_2)$ and $(x_2, y_1)$ exist in our set?
"""

class Solution:
    def minAreaRect(self, points: List[List[int]]) -> int:
        # Create a set of tuples for O(1) lookup speed
        point_set = {tuple(p) for p in points}
        min_area = float('inf')

        # Iterate through every pair of points
        for i in range(len(points)):
            x1, y1 = points[i]
            for j in range(i + 1, len(points)):
                x2, y2 = points[j]
                
                # To form a diagonal of an axis-aligned rectangle:
                # 1. x coordinates must be different
                # 2. y coordinates must be different
                if x1 != x2 and y1 != y2:
                    # Check if the other two corners of the rectangle exist
                    if (x1, y2) in point_set and (x2, y1) in point_set:
                        area = abs(x1 - x2) * abs(y1 - y2)
                        min_area = min(min_area, area)
        
        return min_area if min_area != float('inf') else 0