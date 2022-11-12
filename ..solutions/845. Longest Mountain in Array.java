class Solution {
    public int longestMountain(int[] arr) {
        int answer = 0;
        int n = arr.length;
​
        // go from 1...n-2
        // seems Time: O(N2)
        for (int i = 1; i <= n-2; i++) {
            /*
             * find if arr[i] is peak
             * how? --> arr[i] > arr[i] > arr[i+1]
             */
​
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                int j = i;
                int size = 1;
​
                // left neighours
                while (j > 0 && arr[j] > arr[j-1]) {
                    size++;
                    j--;
                }
​
                // right neighbours
                j = i;
                while (j < n - 1 && arr[j] > arr[j+1]) {
                    size++;
                    j++;
                }
​
                answer = Math.max(answer, size);
            } else {
                // i++;
            }
        }
        
        /**
            optimization would be-
            you already know by the right neighbours who are the peak values
            so you can increment i pointer directly, 
            not to create dependency upon j for rightward traversal
            TIME: O(N)
        */
​
        return answer;
    }
}
