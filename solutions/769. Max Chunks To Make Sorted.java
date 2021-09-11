class Solution {
    public int maxChunksToSorted(int[] arr) {
        return maxChunksToSorted1(arr);
    }
    public int maxChunksToSorted1(int[] arr) {
        int chunks = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if(max == i)
                chunks++;
        }
        return chunks;
    }
​
}
