class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
         * find the possible starting points if Gas > cost then only porer station e
         * jete parbo!
         */
​
        final int n = gas.length;
        List<Integer> possibleStartingPoints = getPossibleStation(gas, cost);
        
        for (int startPoint : possibleStartingPoints) {
            int fuel = 0;
            boolean status = true;
            for (int point = startPoint; point < startPoint + n; point++) {
                int station = point % n;
                fuel += gas[station] - cost[station];
                if (fuel < 0) {
                    status = false;
                    break;
                }
            }
            if (status == true) return startPoint;
        }
        return -1;
    }
    
        private static List<Integer> getPossibleStation(int[] gas, int[] cost) {
        // TODO Auto-generated method stub
        List<Integer> indexes = new ArrayList<Integer>();
​
        for (int i = 0; i < gas.length; i++) {
            int g = gas[i];
            int c = cost[i];
            if (g >= c)
                indexes.add(i);
        }
​
        return indexes;
    }
    
}
