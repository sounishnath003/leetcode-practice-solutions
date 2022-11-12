import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.LogManager;
​
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, answer, new ArrayList<>());
        return answer;
    }
​
    private void combinationSum2(int[] candidates, int target, int curIndex, List<List<Integer>> answer,
            ArrayList<Integer> arrayList) {
​
        if (target < 0)
            return;
​
        if (target == 0) {
            answer.add(new ArrayList<>(arrayList));
            return;
        }
​
        for (int index = curIndex; index < candidates.length; index++) {
            int value = candidates[index];
​
            if (value > target)
                break;
            if (index > curIndex && value == candidates[index - 1])
                continue;
​
            arrayList.add(value);
            combinationSum2(candidates, target - value, index + 1, answer, arrayList);
            arrayList.remove(arrayList.size() - 1);
        }
​
    }
}
