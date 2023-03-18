class BrowserHistory {
​
    private static class NodeHead {
        String url;
        NodeHead previous;
        NodeHead next;
​
        public NodeHead(String url, NodeHead previous, NodeHead next) {
            super();
            this.url = url;
            this.previous = previous;
            this.next = next;
        }
​
    }
​
    private NodeHead urlsQueue;
​
    public BrowserHistory(String homepage) {
        NodeHead currentSite = new NodeHead(homepage, null, null);
        urlsQueue = currentSite;
    }
​
    public void visit(String url) {
        NodeHead currentSite = new NodeHead(url, urlsQueue, null);
        urlsQueue.next = currentSite;
        urlsQueue = currentSite;
    }
​
    public String back(int steps) {
        NodeHead current = urlsQueue;
        while (current.previous != null && steps > 0) {
            current = current.previous;
            steps -= 1;
        }
        if (current==null) return null;
        urlsQueue=current;
        return current.url;
    }
​
    public String forward(int steps) {
        NodeHead current = urlsQueue;
        while (current.next != null && steps > 0) {
            current = current.next;
            steps -= 1;
        }
        if (current==null) return null;
        urlsQueue=current;
        return current.url;
    }
}
​
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
