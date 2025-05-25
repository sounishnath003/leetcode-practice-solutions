class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low = max(weights) # The minimum capacity must be at least the largest single weight
        high = sum(weights) # The maximum capacity is the sum of all weights
        ans = high

        def is_possible(capacity):
            required_days = 1
            current_weight = 0
            for weight in weights:
                if current_weight + weight > capacity:
                    required_days += 1
                    current_weight = weight
                else:
                    current_weight += weight
            return required_days <= days

        while low <= high:
            mid = (low + high) // 2
            if is_possible(mid):
                ans = min(ans,mid)
                high = mid - 1
            else:
                low = mid + 1

        return ans