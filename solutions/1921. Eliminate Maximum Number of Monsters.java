class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        final int n = dist.length;
        
        double[] times = new double[n];
        for (int i = 0; i < n; i++) {
            times[i] = ((1.0 * dist[i]) / (1.0 * speed[i]) );  // t = d / v;
        }
​
        Arrays.sort(times); // asc
​
        int tm = 0, killedMonesters = 0;
        for (double t : times) {
            if (t <= tm) {
                return killedMonesters;
            }
            killedMonesters++;
            tm++;
        }
        return killedMonesters;
​
        // int killedMonesters = 1;
​
        // for (int i = 1; i < dist.length; i++) {
        //     int d = dist[i];
        //     int s = speed[i];
            
        //     int ld = d - s;
        //     if (ld < 0) {
        //         return killedMonesters;
        //     }
        //     dist[i] = ld;
        //     killedMonesters++;
        // }
​
        // return killedMonesters;
    }
}
​
