class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        comboSum(arr, target, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    private static void comboSum(int[] arr, int target, int curindex, List<Integer> store, List<List<Integer>> result) {
​
        if (curindex == arr.length) {
            if (target == 0) {
                result.add(new ArrayList<>(store));
            }
            return ;
        }
​
        int sum = target - arr[curindex] ;
        if (sum >= 0) {
            store.add(arr[curindex]);
            comboSum(arr, sum, curindex, store, result);
            store.remove(store.size() - 1);
        }
        comboSum(arr, target, curindex + 1, store, result);
    }
}
