class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] passengersByStops = new int[100000];
        for (int[] trip : trips) {
            int passengers = trip[0]; // passengers
            int sourceIndex = trip[1]; // sourceId
            int destinationIndex = trip[2]; // sourceId
            
            passengersByStops[sourceIndex] += passengers;
            passengersByStops[destinationIndex] -= passengers;
        }
        
        int totalPassengers = 0;
        for (int i = 0; i < passengersByStops.length; i++) {
            totalPassengers += passengersByStops[i];
            if (totalPassengers > capacity) {
                return false;
            }
        }
        
        return true;
    }
}
