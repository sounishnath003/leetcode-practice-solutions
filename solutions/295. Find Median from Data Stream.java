class MedianFinder {
​
    /** initialize your data structure here. */
​
    private List<Integer> list;
​
    // actually we need 2 Priority Queues, one for left half and one for right
    PriorityQueue<Integer> firstHalf;
    PriorityQueue<Integer> secondHalf;
​
    public MedianFinder() {
        this.list = new ArrayList<Integer>();
        this.firstHalf = new PriorityQueue<>(Collections.reverseOrder());
        this.secondHalf = new PriorityQueue<>();
    }
​
    public void addNum(int num) {
        this.list.add(num);
        if (secondHalf.isEmpty() == false && secondHalf.peek() < num) {
            this.secondHalf.add(num);
        } else {
            this.firstHalf.add(num);
        }
​
        if (this.firstHalf.size() - this.secondHalf.size() == 2) {
            this.secondHalf.add(this.firstHalf.poll());
        } else if (this.secondHalf.size() - this.firstHalf.size() == 2) {
            this.firstHalf.add(this.secondHalf.poll());
        }
    }
​
    public double findMedian() {
        int size1 = this.firstHalf.size();
        int size2 = this.secondHalf.size();
​
        if (size1 == size2) {
            return (this.firstHalf.peek() + this.secondHalf.peek()) / 2.0;
        } else if (size1 >= size2) {
            return this.firstHalf.peek();
        } else if (size1 < size2) {
            return this.secondHalf.peek();
        } else {
            // do nothing
        }
        return -1;
    }
}
​
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
