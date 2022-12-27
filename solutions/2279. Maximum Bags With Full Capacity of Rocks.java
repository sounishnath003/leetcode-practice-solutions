class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        /*
         * 1. try to fill the maximum rocks with the capacity 2. means sort the array by
         * the capacity and present rocks 3. try to fill the rocks with additional rocks
         * till its 0
         */
        int[] remainingSpace = new int[capacity.length];
        for(int i =0; i<capacity.length;i++){
               remainingSpace[i] = capacity[i] - rocks[i];
        }
​
        Arrays.sort(remainingSpace);
        int ans = 0;
        for(int i =0;i<capacity.length;i++){
            if(remainingSpace[i] == 0){
                ans++;
            }else{
              if(additionalRocks>=remainingSpace[i]){
                additionalRocks = additionalRocks - remainingSpace[i];
                ans++;
               }else{
                   break;
               }
            }
        }
        return ans;
    }
​
}
​
