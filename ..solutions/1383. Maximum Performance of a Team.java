class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
         int[][] players = new int[n][2];
            for (int i=0; i<n; i++) {
                players[i][0] = efficiency[i];
                players[i][1] = speed[i];
            }
            Arrays.sort(players, (p1, p2) -> (p2[0] - p1[0]));
            PriorityQueue<Integer> q= new PriorityQueue<>(k);
            long count = 0, s = 0;
​
            for (int i=0; i<n; i++) {
                if (q.size() >= k) {
                   s -= q.remove();
                }
                q.add(players[i][1]);
                s += players[i][1];
​
                count = Math.max(count,s * players[i][0]);
            }
            return (int) (count % 1000000007);
    }
}
