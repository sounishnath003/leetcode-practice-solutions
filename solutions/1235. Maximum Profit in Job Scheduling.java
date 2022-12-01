class Solution {
    private static class JobInfo implements Comparable<JobInfo> {
        int starttime;
        int endtime;
        int profit;
​
        public JobInfo(int starttime, int endtime, int profit) {
            super();
            this.starttime = starttime;
            this.endtime = endtime;
            this.profit = profit;
        }
​
        @Override
        public String toString() {
            return "JobInfo [starttime=" + starttime + ", endtime=" + endtime + ", profit=" + profit + "]";
        }
​
        @Override
        public int compareTo(JobInfo o) {
            // TODO Auto-generated method stub
            return this.endtime - o.endtime;
        }
    }
​
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<JobInfo> jobs = new ArrayList();
        for (int i = 0; i < n; i++) {
            jobs.add(new JobInfo(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(jobs);
​
        System.out.println(jobs);
        int[] dp = new int[n + 1];
        dp[0] = jobs.get(0).profit;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], jobs.get(i).profit);
            for (int j = i - 1; j >= 0; j--) {
                if (jobs.get(j).endtime <= jobs.get(i).starttime) {
                    dp[i] = Math.max(dp[i], jobs.get(i).profit + dp[j]);
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}
