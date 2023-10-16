​
class Solution {
    private Map<String, Integer> cache = new HashMap<>();
    private int MOD = 1000000007;
​
    public int numWays(int steps, int arrLen) {
        return exploreAllWays(steps, arrLen, 0, "*");
    }
​
    private int exploreAllWays(int steps, int arrLen, int currentIndex, String choosen) {
​
        if (steps < 0 || currentIndex < 0 || currentIndex >= arrLen)
            return 0;
​
        String key = "" + steps + "#" + currentIndex;
        if (cache.containsKey(key))
            return cache.get(key);
​
        // System.out.println("i am triggered....");
​
        if (steps == 0 && currentIndex == 0) {
            // System.out.println(choosen);
            return 1;
        }
​
        int rres = 0;
        rres = (rres + (exploreAllWays(steps - 1, arrLen, currentIndex + 1, choosen + "-RIGHT") % MOD)) % MOD;
        rres = (rres + (exploreAllWays(steps - 1, arrLen, currentIndex - 1, choosen + "-LEFT") % MOD)) % MOD;
        rres = (rres + (exploreAllWays(steps - 1, arrLen, currentIndex, choosen + "-STAY") % MOD)) % MOD;
​
        int out = rres % MOD;
        cache.put(key, out);
​
        return out;
    }
}
