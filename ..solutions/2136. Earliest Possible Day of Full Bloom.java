class Solution {
    private class PlantInfo implements Comparable<PlantInfo> {
        int plantTime;
        int growTime;
​
        public PlantInfo(int plantTime, int growTime) {
            this.plantTime = plantTime;
            this.growTime = growTime;
        }
​
        @Override
        public String toString() {
            return "PlantInfo [plantTime=" + plantTime + ", growTime=" + growTime + "]";
        }
​
        @Override
        public int compareTo(PlantInfo o) {
            // TODO Auto-generated method stub
            if (this.growTime == o.growTime) {
                return o.plantTime - this.plantTime;
            }
            Integer pt = o.growTime;
            return pt.compareTo(this.growTime);
        }
​
    }
​
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<PlantInfo> plants = new ArrayList<>();
        for (int i = 0; i < plantTime.length; i++) {
            plants.add(new PlantInfo(plantTime[i], growTime[i]));
        }
​
        int atleastDays = 0;
        // Sort based on plattime and growtime
        Collections.sort(plants);
        // System.out.println(plants);
​
        for (int i = 0, plantsum = 0; i < plants.size(); i++) {
            PlantInfo plant = plants.get(i);
            int elapsedTimeToBlossom = plant.plantTime + plant.growTime + plantsum;
            atleastDays = Math.max(atleastDays, elapsedTimeToBlossom);
            plantsum += plant.plantTime;
        }
​
        return atleastDays;
    }
}
