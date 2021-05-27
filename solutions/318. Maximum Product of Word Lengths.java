class Solution {
    public int maxProduct(String[] words) {
        int ans = Integer.MIN_VALUE;
        final int n = words.length;
​
        for (int i = 0; i < n; i++) {
            String word1 = words[i];
            HashSet<Character> set = this.prepareHashSet(word1);
​
            int innerMax = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                String word2 = words[j];
                boolean status = false;
​
                for (Character c : word2.toCharArray()) {
                    if (set.contains(c)) {
                        status = true;
                        break;
                    }
                }
                if (status == false) {
                    innerMax = Math.max(innerMax, word2.length());
                }
            }
            ans = Math.max(ans, innerMax * word1.length());
        }
​
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
​
    private HashSet<Character> prepareHashSet(String word1) {
        // TODO Auto-generated method stub
        HashSet<Character> set = new HashSet<>();
        for (Character c : word1.toCharArray()) {
            set.add(c);
        }
        return set;
    }
}
