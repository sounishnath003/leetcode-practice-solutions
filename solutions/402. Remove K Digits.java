class Solution {
​
    public String removeKdigits(String s, int k) {
        // if the length is to remove the equal length of s
        // it is as good as "0" (returning the same)
        if (s.length() == k)
            return "0";
​
        // stores into stack.
        Stack<Character> stack = new Stack<>();
        // iterate over the characters
        for (char c : s.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && toInt(stack.peek()) > toInt(c)) {
                // simply pop off
                stack.pop();
                k--;
            }
            stack.add(c);
        }
​
        /// while k is left
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        // if (!stack.isEmpty()) == "0";
​
        // StringBuilder to store the result
        StringBuilder resultSb = new StringBuilder();
        while (!stack.isEmpty()) {
            resultSb.append(stack.pop());
        }
​
        // remove the left over zeros from front
        while (resultSb.length() != 0 && resultSb.charAt(resultSb.length() - 1) == '0') {
            resultSb.deleteCharAt(resultSb.length() - 1);
        }
​
        String res = resultSb.reverse().toString();
        return res.equals("") ? "0" : res;
    }
​
    private int toInt(Character peek) {
        // TODO Auto-generated method stub
        return (int) (peek - '0');
    }
}
