class Solution:
    def rain_water_tapping(self, buildings: list[int]) -> int:
        if not buildings:  # Edge case: Empty list
            return 0

        n = len(buildings)

        # Arrays to store the highest left and right walls at each index
        left_walls = [0] * n
        right_walls = [0] * n

        # Fill left_walls
        left_walls[0] = buildings[0]
        for i in range(1, n):
            left_walls[i] = max(left_walls[i - 1], buildings[i])

        # Fill right_walls
        right_walls[n - 1] = buildings[n - 1]
        for i in range(n - 2, -1, -1):
            right_walls[i] = max(right_walls[i + 1], buildings[i])

        # Calculate trapped water
        water_count = 0
        for i in range(n):
            water_count += min(left_walls[i], right_walls[i]) - buildings[i]

        return water_count


    def trap(self, height: List[int]) -> int:
        return self.rain_water_tapping(height)