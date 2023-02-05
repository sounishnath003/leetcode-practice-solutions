class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int num : arr1) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }
​
        int index = 0;
        for (int key : arr2) {
            // if key in map then populate in arr1
            if (map.containsKey(key)) {
                // insert the freq x times in arr1
                int times = map.get(key);
                while (times > 0) {
                    arr1[index] = key;
                    index++;
                    times--;
                }
                map.remove(key);
            }
        }
​
        for (Map.Entry<Integer, Integer> kv : map.entrySet()) {
            int key = kv.getKey();
            int times = kv.getValue();
            while (times > 0) {
                arr1[index] = key;
                index++;
                times--;
            }
        }
​
        return arr1;
    }
}
​
