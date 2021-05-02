class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
       int n = a.length;
        int m = b.length;
        int i = 0, j = 0, k = 0;
        
        int[] combo = new int[n+m];
        // feed all elems into ONE
        while(i < n && j < m) {
            combo[k++] = (a[i] > b[j]) ? b[j++] : a[i++];
        }
        // if any elem left in a[]
        while(i < n) {
            combo[k++] = a[i++];
        }
        // if any elem left in b[]
        while(j < m)
            combo[k++] = b[j++];
        
        int hf = (int) ((n + m) / 2);
​
        if (combo.length % 2 == 0) {
            // if even
            return (double) (combo[hf - 1] + combo[hf]) / 2;
        }
        return (double) combo[hf] ;
    }
}
