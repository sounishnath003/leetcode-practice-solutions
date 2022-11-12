class Pair extends LinkedList<Pair> {
    int start;
    int end;
    Pair next;
​
    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
​
}
​
class MyCalendar {
​
    private Pair eventStorage;
​
    public MyCalendar() {
        Pair dummyTail = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.eventStorage = new Pair(-1, -1);
        this.eventStorage.next = (dummyTail);
    }
​
    public boolean book(int start, int end) {
        Pair currentNode = this.eventStorage;
        Pair tempNode = this.eventStorage;
​
        /*
         * ami joto khon na faka starttime pabo curr node k egiye niye jabo
         */
​
        while (currentNode.start < start) {
            tempNode = currentNode;
            currentNode = currentNode.next;
        }
​
        // jodi already sesh besi event reggister kora thake
        // OR: prebooked kono event already ache, jar start time end er interval e
        // conflict korche
        if (tempNode.end > start || currentNode.start < end) {
            return false;
        }
​
        Pair newEvent = new Pair(start, end);
        newEvent.next = currentNode;
        tempNode.next = newEvent;
​
        // means booking newa hoye gelo
        return true;
    }
}
​
/**
* Your MyCalendar object will be instantiated and called as such:
* MyCalendar obj = new MyCalendar();
* boolean param_1 = obj.book(start,end);
*/
