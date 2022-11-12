class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> minheap = new PriorityQueue<>(); // default: minheap
        // for (int elem : nums) {
        //     minheap.offer(elem);
        //     if (minheap.size() > k) {
        //         minheap.remove();
        //     }
        // }
        // return minheap.peek();
        
        return KthInArray(nums, k);
    }
    
    // TC: O(N), SC: O(1)
    public int KthInArray(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int index = arr.length - k;
​
        while (start <= end) {
            int paritionIndex = parition(arr, start, end);
            if (paritionIndex == index) {
                return arr[paritionIndex];
            } else if (paritionIndex > index) {
                end = paritionIndex - 1;
            } else {
                start = paritionIndex + 1;
            }
        }
        return arr[start];
    }
    
    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
​
    private int parition(int[] arr, int start, int end) {
        // TODO Auto-generated method stub
        int pivot = end;
        
        int i = start;
        int j = end;
        
        while (i < j) {
            while (i < j && arr[i] <= arr[pivot]) {
                i++;
            }
            
            while (i < j && arr[j] >= arr[pivot]) {
                j--;
            }
            
            swap(arr, i, j);
        }
        
        swap(arr, i, pivot);
        
        return i;
    }
}
