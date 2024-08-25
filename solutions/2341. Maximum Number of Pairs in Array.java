import java.util.HashMap;
import java.util.Map;
​
class Solution {
    public int[] numberOfPairs(int[] nums) {
        int totalPairs = 0;
        int leftOverElems = 0;
​
        Map<Integer, Integer> map = new HashMap<>();
        // store the elems into map
        for (int elem : nums) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }
​
        // iterate on map
        for (Map.Entry<Integer, Integer> kv : map.entrySet()) {
            int occurency = kv.getValue();
​
            // as pair == 2 elements.
            // we can do occurency % 2
            // // totalpairs will be the vagfol
            // leftover will be the reminder
​
            totalPairs += occurency / 2;
            leftOverElems += occurency % 2;
        }
​
        return new int[] { totalPairs, leftOverElems };
    }
​
}
