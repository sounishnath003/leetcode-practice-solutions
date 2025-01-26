class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {

        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        int topElement = queue1.poll();
        queue1 = queue2;
        queue2 = new LinkedList<>();

        return topElement;

    }

    public int top() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        int topElement = queue1.poll();
        queue2.add(topElement);
        queue1 = queue2;
        queue2 = new LinkedList<>();

        return topElement;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
