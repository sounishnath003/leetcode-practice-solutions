

public class LRUCache {

    private class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // check if the key exists in map
        if (this.map.containsKey(key)) {
            // get the node out
            Node node = this.map.get(key);
            remove(node);
            add(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            add(node);
        }

        else if (this.capacity == 0) {
            // remove least recently used node
            remove(tail.prev);
            // create a node
            Node node = new Node(key, value);
            // add them
            add(node);
        }

        else {
            Node node = new Node(key, value);
            add(node);
        }
    }

    private void add(Node node) {
        Node headnext = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        node.next = headnext;
        headnext.prev = node;

        this.map.put(node.key, node);
        this.capacity--;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

        this.map.remove(node.key);
        this.capacity++;
    }
}


class LRUCache2 {

    private HashMap<Integer, Integer> cache = null;
	private int capacity = 0;
	public LRUCache2(int capacity) {
	        this.cache = new LinkedHashMap<>(capacity);
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	    	if(this.cache.containsKey(key)) {
	    		int val = cache.get(key);
		        this.cache.remove(key);
		        this.cache.put(key, val);
		        return val;
	    	}
	        return -1;
	    }
	    
	    public void put(int key, int value) {
	    	if (cache.containsKey(key)) {
	    		this.cache.remove(key);
	    	} else if(this.cache.size() == this.capacity) {
                this.cache.remove(this.cache.keySet().iterator().next());
            }
	    	
            this.cache.put(key, value);
	    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
