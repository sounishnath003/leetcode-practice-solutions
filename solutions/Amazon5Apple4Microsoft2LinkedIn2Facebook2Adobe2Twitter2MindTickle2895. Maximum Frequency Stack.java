class FreqStack {
  private Map<Integer, Stack<Integer>> stackMap = new HashMap<>(); // <freq, stack>
    private Map<Integer, Integer> accessCountMap = new HashMap<>(); // <freq, count>
    int maximumFrequency = 0;
​
    void push(int val) {
        accessCountMap.put(val, accessCountMap.getOrDefault(val, 0) + 1);
        maximumFrequency = Math.max(maximumFrequency, accessCountMap.get(val));
​
        stackMap.putIfAbsent(accessCountMap.get(val), new Stack<>());
        stackMap.get(accessCountMap.get(val)).add(val);
    }
​
    int pop() {
        // return the val whose accessControl Map is too latest...
        int elem = stackMap.get(maximumFrequency).pop();
        // work on the maximumFreq reduction logic
        if (stackMap.get(maximumFrequency).size() == 0) {
            maximumFrequency--;
        }
        accessCountMap.put(elem, accessCountMap.get(elem) - 1);
​
        return elem;
    }
}
​
/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
