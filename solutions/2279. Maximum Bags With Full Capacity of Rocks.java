class Solution {
    private class RockBag implements Comparable<RockBag> {
        int capacity;
        int presentRocks;
        int extraRequired;
​
        public RockBag(int capacity, int presentRocks) {
            super();
            this.capacity = capacity;
            this.presentRocks = presentRocks;
            this.extraRequired = (capacity - presentRocks);
        }
​
        @Override
        public String toString() {
            return "RockBag [capacity=" + capacity + ", presentRocks=" + presentRocks + ", extraRequired="
                    + extraRequired + "]";
        }
​
        @Override
        public int compareTo(RockBag o) {
            // TODO Auto-generated method stub
            // descending order sorting
            return this.extraRequired - o.extraRequired;
        }
    }
​
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        /*
         * 1. try to fill the maximum rocks with the capacity 2. means sort the array by
         * the capacity and present rocks 3. try to fill the rocks with additional rocks
         * till its 0
         */
        RockBag[] bags = getRockBags(capacity, rocks);
        Printer.log(Arrays.toString(bags));
        Arrays.sort(bags);
        Printer.log(Arrays.toString(bags));
​
        int target = 0;
        for (int i = 0; i < bags.length && additionalRocks > 0; i++) {
            additionalRocks = additionalRocks - bags[i].extraRequired;
            if (additionalRocks>0) target++;
        }
        return target;
    }
​
    private RockBag[] getRockBags(int[] capacity, int[] rocks) {
        RockBag[] bags = new RockBag[capacity.length];
        for (int i = 0; i < bags.length; i++)
            bags[i] = new RockBag(capacity[i], rocks[i]);
        return bags;
    }
}
​
