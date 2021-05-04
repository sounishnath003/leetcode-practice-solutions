class LRUCache {
​
    private HashMap<Integer, Integer> cache = null;
    private int capacity = 0;
    public LRUCache(int capacity) {
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
            } else if(this.cache.size() == this.capacity) this.cache.remove(this.cache.keySet().iterator().next());
            this.cache.put(key, value);
        }
}
​
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
