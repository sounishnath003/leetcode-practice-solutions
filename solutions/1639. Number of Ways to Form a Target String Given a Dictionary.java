// https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/
class Solution {
    Map<String, Integer> memoMap = new HashMap<>();
    int MOD=(int) (1e9+7);
​
    public int numWays(String[] words, String target) {
        int max_characters = 26;
        int max_length = words[0].length();
        int[][] frequencyTable = new int[max_characters][max_length];
        for (int index = 0; index < max_length; index++) {
            for (String word : words) {
                char character = word.charAt(index);
                int characterIndex = character - 'a';
                frequencyTable[characterIndex][index]++;
            }
        }
        for (int[] row : frequencyTable)
            System.out.println(Arrays.toString(row));
        return solve(target, 0, 0, frequencyTable);
    }
​
    private int solve(String target, int wordIndex, int targetIndex, int[][] frequencyTable) {
        if (targetIndex == target.length())
            return 1;
        if (wordIndex == frequencyTable[0].length)
            return 0;
​
        if (memoMap.containsKey(targetIndex + "@" + wordIndex))
            return memoMap.get(targetIndex + "@" + wordIndex);
​
        int notTaken = solve(target, wordIndex + 1, targetIndex, frequencyTable);
        int frequencyTimes = frequencyTable[target.charAt(targetIndex) - 'a'][wordIndex];
        int taken = (solve(target, wordIndex + 1, targetIndex + 1, frequencyTable) * frequencyTimes)%MOD;
​
        int totalWays = (notTaken + taken) % MOD;
        memoMap.put(targetIndex + "@" + wordIndex, totalWays);
        return totalWays;
    }
}
