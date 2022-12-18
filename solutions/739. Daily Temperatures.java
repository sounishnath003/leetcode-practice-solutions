import java.util.Arrays;
import java.util.Stack;
​
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answers = new int[n];
        Stack<Integer> stack = new Stack<>();
​
        for (int i = n - 1; i >= 0; i--) {
            int temperature = temperatures[i];
            if (stack.isEmpty()) {
                answers[i] = 0;
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperature) {
                    stack.pop();
                }
                answers[i] = stack.isEmpty() ? 0 : (stack.peek()-i);
            }
            stack.add(i);
        }
​
        return answers;
    }
}
