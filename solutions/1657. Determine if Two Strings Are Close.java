class Solution {
​
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> map1 = buildFrequencyMap(word1);
        Map<Character, Integer> map2 = buildFrequencyMap(word2);
​
        if (map1.equals(map2))
            return true;
        return canBeMapped(map1, map2) ? true : false;
    }
​
    private boolean canBeMapped(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (!map1.keySet().equals(map2.keySet()))
            return false;
​
        Map<Integer, List<Character>> reverseMap1 = buildReverseMap(map1);
        Map<Integer, List<Character>> reverseMap2 = buildReverseMap(map2);
​
        for (Map.Entry<Integer, List<Character>> kv : reverseMap1.entrySet()) {
            List<Character> set1 = kv.getValue();
            List<Character> set2 = reverseMap2.get(kv.getKey());
            if (set2 == null || set1.size() != set2.size())
                return false;
        }
​
        return true;
    }
​
    private Map<Integer, List<Character>> buildReverseMap(Map<Character, Integer> map1) {
        Map<Integer, List<Character>> rmap = new HashMap<>();
        for (Map.Entry<Character, Integer> kv : map1.entrySet()) {
            rmap.putIfAbsent(kv.getValue(), new ArrayList<>());
            rmap.get(kv.getValue()).add(kv.getKey());
        }
        return rmap;
    }
​
    private Map<Character, Integer> buildFrequencyMap(String word1) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
