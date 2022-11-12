class Solution {
    
    class Pair {
        int cost;
        int index;
​
        Pair(int cost, int index) {
            this.cost = cost;
            this.index = index;
        }
    }
​
    public int maxResult(int[] nums, int k) {
            final int n = nums.length;
            int result = nums[0];
​
            PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((a, b) -> b.cost - a.cost);
            priorityQueue.add(new Pair(nums[0], 0));
​
            for (int i = 1; i < n; i++) {
                while (priorityQueue.isEmpty() == false && priorityQueue.peek().index < i - k)
                    priorityQueue.remove();
​
                result = priorityQueue.peek().cost + nums[i];
                priorityQueue.add(new Pair(result, i));
            }
​
            return result;
        }
}
