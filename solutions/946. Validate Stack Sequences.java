class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length, j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int elem = pushed[i];
            stack.add(elem);
            j = removeElemfromStack(popped, j, stack);
        }
        while(j < popped.length) {
            int topelem = stack.peek();
            int popelem = popped[j];
            if (topelem == popelem) { stack.pop(); j++; }
            else { return false; }
        }
        return true;
    }
    private static int removeElemfromStack(int[] popped, int j, Stack<Integer> stack) {
        while(stack.isEmpty()==false) {
            if (stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else {
                break;
            }
        }
        return j;
    }
}
