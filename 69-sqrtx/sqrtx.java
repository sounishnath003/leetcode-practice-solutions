class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x; // Handle small cases directly

        int low = 1;
        int high = x / 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Avoid overflow by using division
            if (mid > x / mid) {
                high = mid - 1;
            } else if (mid < x / mid) {
                low = mid + 1;
            } else {
                return mid; // Exact square root found
            }
        }

        return high; // `high` is the largest number whose square is <= x
    }
}
