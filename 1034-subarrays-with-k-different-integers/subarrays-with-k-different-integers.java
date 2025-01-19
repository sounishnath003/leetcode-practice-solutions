class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // 1 2 3
        // 1 2

        // subtract = K = [3]
        // thats my answer
        return countOfSubarr(nums, k) - countOfSubarr(nums, k-1);
    }

    private int countOfSubarr(int[] arr, int k) {
        Map<Integer, Integer> map=new HashMap<>(); // <int, freq>

        int totalSubarr = 0;

        int start=0;
        // find window
        for (int end = 0; end < arr.length; end++) {
            int e = arr[end];
            map.put(e, map.getOrDefault(e, 0) + 1); // add in map
            // if map size > k
            if (map.size() > k) {
                // shrink window and remove elem
                while (start <= end && !map.isEmpty() && map.size() > k) {
                    // decrement the counter
                    map.put(arr[start], map.get(arr[start]) - 1);
                    // if m[arr[start]] == 0 remove the key
                    if ( map.containsKey(arr[start]) && map.get(arr[start]) == 0) {
                        map.remove(arr[start]);
                    }
                    start++;
                }
            }

            // this will count all subarray ends at index `end`
            // which contains both <= K elements
            // as we dont have put any sense there.
            totalSubarr += (end - start + 1); 
        }

        return totalSubarr;
    }
}