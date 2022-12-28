class Solution {
    public int minStoneSum(int[] stones, int k) {
        // minimize and K === PQ question
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones)
            priorityQueue.add(stone);
        int totalSum = Arrays.stream(stones).sum();
​
        while (k>0 && !priorityQueue.isEmpty()) {
            int peek = priorityQueue.poll();
            int peakhalf = Math.floorDiv(peek, 2);
            totalSum -= peakhalf;
            priorityQueue.add(peek-peakhalf);
            k--;
        }
​
        return totalSum;
    }
}
​
