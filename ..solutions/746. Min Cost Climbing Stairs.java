class Solution {
    private HashMap<Integer, Integer> dp = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        int finalCost = this._minCostClimbingStairs(cost, cost.length);
        return finalCost;
    }
​
    private int _minCostClimbingStairs(int[] cost, int curIndex) {
​
        if (curIndex < 2)
            return 0;
​
        if (dp.containsKey(curIndex))
            return this.dp.get(curIndex);
​
        // faith
        int costWithStep1 = this._minCostClimbingStairs(cost, curIndex - 1);
        int costWithStep2 = this._minCostClimbingStairs(cost, curIndex - 2);
​
        costWithStep1 += cost[curIndex-1];
        costWithStep2 += cost[curIndex-2];
​
        int minSoFar = Math.min(costWithStep1, costWithStep2);
​
        this.dp.put(curIndex, minSoFar);
        return minSoFar;
    }
}
