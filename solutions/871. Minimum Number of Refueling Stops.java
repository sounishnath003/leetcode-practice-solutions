class Solution {
    class Pair {
        int fuel;
        int mile;
​
        public Pair(int fuel, int mile) {
            // TODO Auto-generated constructor stub
            this.fuel = fuel;
            this.mile = mile;
        }
​
        @Override
        public String toString() {
            return "Pair [fuel=" + fuel + ", mile=" + mile + "]";
        }
    }
​
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int minFuelStop = 0;
​
        if (startFuel >= target)
            return 0;
​
        PriorityQueue<Pair> fuelStations = new PriorityQueue<>(new Comparator<Pair>() {
​
            @Override
            public int compare(Pair o1, Pair o2) {
                // TODO Auto-generated method stub
                if (o2.mile==o1.mile) {
                    return o1.fuel - o2.fuel; 
                }
                return o2.mile - o1.mile;
            }
        
        }); // max heap on fuel
        
        for (int[] station : stations)
            fuelStations.add(new Pair(station[0], station[1]));
        
        int currMile = startFuel;
        while (fuelStations.isEmpty()==false && currMile < target) {
            Pair p = fuelStations.remove();
            System.out.println(p);
            if (currMile >= p.fuel) {
                currMile += p.mile;
                minFuelStop++;
            }
        }
        
        return (target <= currMile) ? minFuelStop : -1;
    }
}
