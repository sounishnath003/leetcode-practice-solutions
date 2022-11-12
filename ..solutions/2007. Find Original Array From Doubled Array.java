class Solution {
    public int[] findOriginalArray(int[] changed) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(changed);
        int n = changed.length;
        if (n%2==1) return new int[]{};
​
        Map<Integer, Integer> map = new HashMap<>();
​
        for (int i = n - 1; i >= 0; i--) {
            int elem = changed[i];
            int doubled = elem * 2;
            if (map.containsKey(doubled)) {
                if (map.get(doubled) == 1) {
                    map.remove(doubled);
                } else {
                    map.put(doubled, map.get(doubled) - 1);
                }
​
                result.add(elem);
            } else {
                map.put(elem, map.getOrDefault(elem, 0) + 1);
            }
        }
​
        return result.size() == n / 2 ? result.stream().mapToInt(Integer::intValue).toArray() : new int[] {};
    }
}
