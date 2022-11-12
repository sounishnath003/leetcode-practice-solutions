class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
​
        // HashMap to store the mapping of characters from s to t
        HashMap<Character, Character> map = new HashMap<>();
        // HashSet to store the mapping of characters from t to s
        HashSet<Character> set = new HashSet<>();
​
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (map.containsKey(sChar)) {
                if (map.get(sChar) != tChar) {
                    return false;
                }
            } else {
                if (set.contains(tChar)) {
                    return false;
                }
                map.put(sChar, tChar);
                set.add(tChar);
            }
        }
        return true;
    }
}
