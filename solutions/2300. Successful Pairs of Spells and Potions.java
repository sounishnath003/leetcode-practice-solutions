class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n=potions.length;
        int[] result=new int[spells.length];
        for (int i=0;i<spells.length;i++) {
            int spell=spells[i];
            int lo=0;
            int hi=n-1;
            int potion_index=n;
            while (lo<=hi){
                int mid=(lo+hi)/2;
                if ((long) spell * potions[mid] >= success) {
                    potion_index=mid;
                    hi=mid-1;
                }else {
                    lo=mid+1;
                }
            }
            int pair_count=n-potion_index;
            result[i]=pair_count;
        }
        return result;
    }
}
