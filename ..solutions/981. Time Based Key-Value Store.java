class TimeMap {
    private Map<String, TreeMap<Integer, String>> cache;
​
    public TimeMap() {
        this.cache = new HashMap<>();
    }
​
    public void set(String key, String value, int timestamp) {
        if (this.cache.containsKey(key)) {
            TreeMap<Integer, String> keystore = this.cache.get(key);
            keystore.put(timestamp, value);
        } else {
            // new entry
            TreeMap<Integer, String> temp = new TreeMap<>();
            temp.put(timestamp, value);
            this.cache.put(key, temp);
        }
    }
​
    public String get(String key, int timestamp) {
        if (this.cache.containsKey(key)) {
            TreeMap<Integer, String> availableKeys = this.cache.get(key);
            Map.Entry<Integer, String> val = availableKeys.floorEntry(timestamp);
            return val == null ? "" : val.getValue();
        }
​
        return "";
    }
}
