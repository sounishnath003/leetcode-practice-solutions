class Solution {
​
    private int[] originalArray;
    private int[] temp;
    private Random random;
    public Solution(int[] nums) {
        this.originalArray = nums.clone();
        this.temp = nums.clone();
        this.random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.temp = this.originalArray.clone(); // .clone() is the fucking hell. to use otherwize object will shallow copy.
        // this deeply copies
        return this.temp;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = this.temp.length - 1; i >= 0; i--) {
            int randomIndex = this.randomIndexGenerator(i+1);
            this.swap(i, randomIndex);
        }
        
        return this.temp;
    }
    
    private void swap(int i, int j) {
        int t = this.temp[i];
        this.temp[i] = this.temp[j];
        this.temp[j] = t;
    }
    
    private int randomIndexGenerator(int rangei) { return this.random.nextInt(rangei) ; }
}
​
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
