class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int prevEndTime = intervals[0][1];
        int total = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            
            int curStartTime = interval[0];
            if (curStartTime >= prevEndTime) {
                prevEndTime = interval[1];
                continue;
            }
            
            total++;
        }
        
        return total;
    }
}
