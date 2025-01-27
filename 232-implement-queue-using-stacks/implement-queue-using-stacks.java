class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        int x = this.peek();
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            // copy all
            while(stack1.isEmpty()==false) stack2.add(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}