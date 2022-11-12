class Solution {
    public int[] sortArray(int[] nums) {
//         PriorityQueue<Integer> heap = new PriorityQueue<>();
//         for (int elem : nums) {
//             heap.add(elem);
//         }
        
//         for (int i = 0; i < nums.length; i++) {
//             nums[i] = heap.remove();
//         }
//         return nums;
        
        HH.heapsort(nums);
        return nums;
    }
}
​
// "static void main" must be defined in a public class.
class HH {
    public static void heapsort(int[] arr) {
        buildHeap(arr);
        
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
    
    private static void buildHeap(int[] arr) {
        int n = arr.length;
        for (int i = n/2; i >= 0; i--) {
            heapify(arr, n, i);   
        }
    }
    
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int lc = 2*i+1;
        int rc = 2*i+2;
        
        if (lc < n && arr[lc] > arr[largest]) largest = lc;
        if (rc < n && arr[rc] > arr[largest]) largest = rc;
        
        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
​
