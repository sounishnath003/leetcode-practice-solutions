class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        return GasStation.startingStation(gas, cost);
    }
}
​
​
public class GasStation {
    private static class Station {
        int index;
        int cost;
        int gas;
        public Station(int index, int cost, int gas) {
            super();
            this.index = index;
            this.cost = cost;
            this.gas = gas;
        }
        @Override
        public String toString() {
            return "Station [index=" + index + ", cost=" + cost + ", gas=" + gas + "]";
        }
        
    }
    public static int startingStation(int[] gases, int[] costs) {
        int n = gases.length;
        Station[] stations = new Station[n];
        for (int i = 0 ; i < n; i++) {
            stations[i] = new Station(i, costs[i], gases[i]);
        }
        
        int shortage = 0;
        int stationpoint = 0;
        int totalShortage = 0;
        
        for (Station station : stations) {
            shortage += (station.gas - station.cost);
            if (shortage < 0) {
                shortage = 0;
                stationpoint = station.index + 1;
            }
            totalShortage += (station.gas - station.cost);
        }
        
        if (totalShortage >= 0) {
            // System.out.println("STP: " + stationpoint);
            return stationpoint;
        } else {
            // System.out.println("STP: " + -1);
            return -1;
        }
    }
}
​
