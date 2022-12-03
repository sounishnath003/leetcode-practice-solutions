class Solution {
    private static class CustomSorter {
        private char[] arr;
        private StringBuilder sb;
​
        public CustomSorter(char[] arr) {
            super();
            this.arr = arr;
        }
​
        public void sort() {
            Map<Character, Integer> map = new HashMap<>();
            for (char x : this.arr)
                map.put(x, map.getOrDefault(x, 0) + 1);
            TreeMap<Integer, List<Character>> rmap = new TreeMap<>(Collections.reverseOrder());
            for (Map.Entry<Character, Integer> kv : map.entrySet()) {
                char key = kv.getKey();
                int value = kv.getValue();
                rmap.putIfAbsent(value, new ArrayList<>());
                for (int i = 0; i < value; i++)
                    rmap.get(value).add(key);
            }
            sb = new StringBuilder();
            for (List<Character> list : rmap.values())
                for (char c : list)
                    sb.append(c);
        }
​
        public String toString() {
            return sb.toString();
        }
    }
​
    public String frequencySort(String s) {
        CustomSorter sorter = new CustomSorter(s.toCharArray());
        sorter.sort();
        return sorter.toString();
    }
}
​
