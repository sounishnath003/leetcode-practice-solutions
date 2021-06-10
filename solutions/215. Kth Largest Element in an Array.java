class Solution {
    
    // HEAP - find K largrest
    // Both are different question
    public static void findKLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) maxHeap.add(arr[i]);
        
        for (int i = k; i < arr.length; i++) {
            int topel = maxHeap.peek();
            if (topel < arr[i]) {
                maxHeap.remove();
                maxHeap.add(arr[i]);
            }
        }
        
        while(maxHeap.isEmpty()==false)
            System.out.println(maxHeap.poll());
    }
    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : nums) pq.add(x);
        while(k-1 > 0) {pq.remove(); k--;}
        return pq.peek();
    }
}
