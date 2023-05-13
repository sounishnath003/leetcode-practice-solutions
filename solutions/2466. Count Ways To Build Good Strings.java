class Solution {
    private final int MOD = (int) 1000000007;
    Map<Integer, Integer> dp = new HashMap<>();
​
    public int countGoodStrings(int low, int high, int zero, int one) {
        return solver(0, low, high, zero, one);
    }
​
    private int solver(int stringLength, int low, int high, int zero, int one) {
        if (stringLength > high)
            return 0;
​
        if (dp.containsKey(stringLength))
            return dp.get(stringLength);
​
        int canAppend = 0;
        if (stringLength >= low && stringLength <= high) {
            canAppend = 1;
        }
​
        int zeroAppend = solver(stringLength + zero, low, high, zero, one);
        int oneAppend = solver(stringLength + one, low, high, zero, one);
​
        int val = (canAppend + (zeroAppend % MOD) + (oneAppend % MOD)) % MOD;
        dp.putIfAbsent(stringLength, val);
        return val;
    }
}
