class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         // low - high 
        // atleast 1 / hr
        int low=1;
        // max capacity is the max # of bananas
        int high = Arrays.stream(piles).max().getAsInt();
        // monotonic incr. so we can apply BS
        while (low <= high) {
            int minRate=(low + (high-low)/2);
            // check if koko can finish by rate of `minRate` in h hour
            if (kokoCanFinish(piles,minRate,h)) {
                // we need to minimize the rate
                high=minRate-1;
            } else {
                // no way, we shud incr.
                low=minRate+1;
            }
        }
        
        // return low
        return low;
    }
    
    private boolean kokoCanFinish(int[] piles, int minRate, int hrs) {
        int timeTaken=0;
        for (int banana : piles) {
            timeTaken +=Math.ceil((double)(banana) / (double)(minRate));
        }
        
        return timeTaken <= hrs;
    }
}
