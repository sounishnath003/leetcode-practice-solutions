class Solution:
    def minHeightShelves(self, books: List[List[int]], shelf_width: int) -> int:
        """
        1. Optimized: Recursion | TC: O(N * W) ; SC: O(N + K)
            1. Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.
            2. Use recursion: Explore all possibilities to find the minimum height from f(i) -> min(h + f(j)) i <= j < n
        """
        n = len(books)

        def fn(i:int, dp: dict[int,int]) -> int:
            if i == n:
                return 0

            if i in dp:
                return dp[i]

            available_width, max_h = shelf_width, 0
            res = float("inf")

            for j in range(i, n):
                book_w, book_h = books[j]
                if available_width >= book_w:
                    max_h = max(max_h, book_h)
                    available_width = available_width - book_w
                    # choose the element to pick the book height
                    res = min(res, max_h + fn(j+1, dp))
                else:
                    break

            dp[i] = res
            return dp[i]

        return fn(0, dp={})
