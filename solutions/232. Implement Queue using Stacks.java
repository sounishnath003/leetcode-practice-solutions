class MyQueue {
    private Stack<Integer> primary;
    private Stack<Integer> secondary;
​
    public MyQueue() {
        primary = new Stack<>();
        secondary = new Stack<>();
    }
​
    public void push(int x) {
        primary.push(x);
    }
​
    public int pop() {
        if (secondary.isEmpty()) {
            while (!primary.isEmpty())
                secondary.add(primary.pop());
        }
        return secondary.pop();
    }
​
    public int peek() {
        if (secondary.isEmpty()) {
            while (!primary.isEmpty())
                secondary.add(primary.pop());
        }
        return secondary.peek();
    }
​
    public boolean empty() {
        return primary.isEmpty() && secondary.isEmpty();
    }
}
​
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
