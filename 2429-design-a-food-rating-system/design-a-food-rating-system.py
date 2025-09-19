import heapq
from collections import defaultdict

class FoodRatings:
    def __init__(self, foods: list[str], cuisines: list[str], ratings: list[int]):
        # Map a food to its cuisine and current rating
        self.food_info = {}
        # Map a cuisine to its max-heap of (-rating, food) tuples
        self.cuisine_to_heap = defaultdict(list)

        for food, cuisine, rating in zip(foods, cuisines, ratings):
            self.food_info[food] = {'cuisine': cuisine, 'rating': rating}
            # Add to the min-heap. For max-heap behavior, negate the rating.
            # Tie-breaking for min-heap is handled by Python's tuple comparison.
            # A tie in -rating means the next element (food) will be compared lexicographically.
            # This is exactly what is needed for max-heap tie-breaking logic.
            heapq.heappush(self.cuisine_to_heap[cuisine], (-rating, food))

    def changeRating(self, food: str, newRating: int) -> None:
        # Update the food's rating in the auxiliary dictionary
        self.food_info[food]['rating'] = newRating
        cuisine = self.food_info[food]['cuisine']

        # Push the new rating onto the heap. This is an O(log n) operation.
        # The old entry is not removed, which is called "lazy deletion".
        heapq.heappush(self.cuisine_to_heap[cuisine], (-newRating, food))

    def highestRated(self, cuisine: str) -> str:
        heap = self.cuisine_to_heap[cuisine]
        
        # We must handle stale entries lazily. The loop continues as long as the top
        # of the heap is a stale entry (its rating doesn't match the current rating).
        while heap:
            neg_rating, food = heap[0]
            current_rating = self.food_info[food]['rating']
            
            # Check if the food at the top of the heap is a stale entry
            if -neg_rating == current_rating:
                return food
            else:
                # If it's stale, remove it and continue checking the new top
                heapq.heappop(heap)
        
        return "" # Should not be reached if the data is consistent
