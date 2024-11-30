​
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
​
    private int capacity;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private Map<Integer, Node> map;
​
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
​
        head.next = tail;
        tail.prev = head;
    }
​
    public int get(int key) {
        // check if the key exists in map
        if (this.map.containsKey(key)) {
            // get the node out
            Node node = this.map.get(key);
            remove(node);
            add(node);
            return node.val;
        }
​
        return -1;
    }
​
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            add(node);
        }
​
        else if (this.capacity == 0) {
            // remove least recently used node
            remove(tail.prev);
            // create a node
            Node node = new Node(key, value);
            // add them
            add(node);
