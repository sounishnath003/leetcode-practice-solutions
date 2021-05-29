class Solution {
    private int[] arr;
    private Set<Integer> visited = new HashSet<>();
    
    public boolean canReach(int[] nums, int start) {
        arr = nums;
        boolean ans = isPossibleToReach(start);
        return ans;
    }
    
    private boolean isPossibleToReach(int curIndex) {
        
        if (curIndex < 0 || curIndex >= arr.length)
            return false;
        
        if (this.visited.contains(curIndex) == true)
            return false;
        
        if (this.arr[curIndex] == 0) return true;
        
        this.visited.add(curIndex);
        
        boolean ans = false;
        if (isPossibleToReach(curIndex + this.arr[curIndex]) == true) ans = true;
        else if (isPossibleToReach(curIndex - this.arr[curIndex]) == true) ans = true;
        
        // backtrack
        this.visited.remove(curIndex);
        
        return ans;
    }
}
