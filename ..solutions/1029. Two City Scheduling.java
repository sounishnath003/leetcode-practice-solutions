public class TwoCityScheduler {
    class CityCost {
        int person;
        int costForA;
        int costForB;
​
        public CityCost(int person, int costForA, int costForB) {
            super();
            this.person = person;
            this.costForA = costForA;
            this.costForB = costForB;
        }
​
        @Override
        public String toString() {
            return "CityCost [person=" + person + ", costForA=" + costForA + ", costForB=" + costForB + "]";
        }
​
    }
​
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        CityCost[] costTrack = new CityCost[n];
​
        for (int i = 0; i < n; i++) {
            int person = i;
            int costa = costs[i][0];
            int costb = costs[i][1];
            costTrack[i] = new CityCost(person, costa, costb);
        }
​
        Arrays.sort(costTrack, new Comparator<CityCost>() {
            public int compare(CityCost a, CityCost b) {
                return (a.costForA - a.costForB) - (b.costForA - b.costForB);
            }
        });
​
        int ans = 0;
        for (int i = 0; i < n/2; i++) {
            ans += (costTrack[i].costForA + costTrack[i+(n/2)].costForB);
        }
​
        return ans;
    }
}
​
