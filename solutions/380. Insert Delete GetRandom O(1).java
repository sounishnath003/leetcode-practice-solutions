class RandomizedSet {
    private Set<Integer> set;
    private List<Integer> list;
    private Random random;
​
    public RandomizedSet() {
        this.set = new HashSet<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }
​
    public boolean insert(int val) {
        if (this.set.contains(val))
            return false;
        this.set.add(val);
        list.add(val);
        return true;
    }
​
    public boolean remove(int val) {
        if (this.set.contains(val)) {
            this.set.remove(val);
            this.list.remove(Integer.valueOf(val));
            return true;
        }
        return false;
    }
​
    public int getRandom() {
        int id = this.random.nextInt(this.set.size());
        return this.list.get(id);
    }
}
​
/**
    * Your RandomizedSet object will be instantiated and called as such:
    * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
    * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
*/
​
