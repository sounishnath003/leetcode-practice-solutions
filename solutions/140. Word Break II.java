class Solution {
    public static class Trie {↔}
​
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String b : wordDict)
            trie.insertWord(b);
​
        Map<String, List<String>> map = new HashMap<>();
        return wordBreak(s, trie, map);
    }
​
    private List<String> wordBreak(String s, Trie trie, Map<String, List<String>> map) {
        List<String> ans = new ArrayList<>();
​
        if (map.containsKey(s)) {
            return map.get(s);
        }
​
        if (trie.search(s)) {
            ans.add(s);
        }
​
        for (int i = 1; i < s.length(); i++) {
            String fpart = s.substring(0, i);
            if (trie.search(fpart)) {
                String ros = s.substring(i, s.length());
                List<String> bbres = wordBreak(ros, trie, map);
​
                for (String r : bbres)
                    ans.add(fpart + " " + r);
            }
        }
​
        map.putIfAbsent(s, ans);
        return ans;
    }
}
