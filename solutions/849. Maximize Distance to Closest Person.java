class Solution {
    public int maxDistToClosest(int[] seats) {
        int dist = 0;
        int zeros = 0;
        int indx = 0;
        // left sub part
        while(seats[indx] != 1) {
            indx++;
            zeros++;
        }
        indx++;
        dist = zeros;
        zeros = 0;
        // segements calculations
        while(indx < seats.length) {
            while(indx < seats.length && seats[indx] != 1) {
                zeros++;
                indx++;
            }
            if(indx == seats.length)
                break;
​
            indx++;
            dist = Math.max(dist, (zeros + 1) / 2);
            zeros = 0;
        }
​
        // right sub part
        return Math.max(zeros, dist);
    }
​
}
