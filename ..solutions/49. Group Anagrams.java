class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
​
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String temp = getDictionaryKey(str);
            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(str);
        }
​
        for (Map.Entry<String, List<String>> kv : map.entrySet()) {
            result.add(new ArrayList<>(kv.getValue()));
        }
​
        return result;
    }
​
    private String getDictionaryKey(String str) {
        char[] tempstr = str.toCharArray();
        Arrays.sort(tempstr);
        String temp = new String(tempstr);
        return temp;
    }
}
