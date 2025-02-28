class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        explore(candidates, result, new ArrayList<>(), target, 0);

        return result;
    }

    private void explore(int[] candidates, List<List<Integer>> result, List<Integer> curr, int target, int i) {
       if (target == 0) {
        result.add(new ArrayList<>(curr));
        return;
       }
       if (target < 0 || i >= candidates.length) return ;
        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j-1]) {
                continue;
            }

            curr.add(candidates[j]);
            explore(candidates, result, curr, target - candidates[j], j + 1);
            curr.remove(curr.size() - 1);
        }
    }
}