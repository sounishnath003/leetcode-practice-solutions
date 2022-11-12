class Solution {
    // TC: O(NLogN)
    // SPACE: O(N) ~ O(1) also done; I just used typed. class definations.
    class BoxType {
        int totalBoxes;
        int unitsPerBox;
​
        public BoxType(int totlaBoxes, int unitPerbox) {
            // TODO Auto-generated constructor stub
            this.totalBoxes = totlaBoxes;
            this.unitsPerBox = unitPerbox;
        }
​
        @Override
        public String toString() {
            return "BoxType [totalBoxes=" + totalBoxes + ", unitsPerBox=" + unitsPerBox + "]";
        }
​
    }
​
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        ArrayList<BoxType> boxes = new ArrayList<>();
        for (int[] boxtype : boxTypes)
            boxes.add(new BoxType(boxtype[0], boxtype[1]));
​
        Collections.sort(boxes, new Comparator<BoxType>() {
            @Override
            // SORT BY DESC
            public int compare(BoxType o1, BoxType o2) {
                // TODO Auto-generated method stub
                return o2.unitsPerBox - o1.unitsPerBox;
            }
        });
​
        int totalUnits = 0;
        int curIndex = 0;
        while (truckSize >= 0 && curIndex < boxes.size()) {
            BoxType curBox = boxes.get(curIndex);
            if (curBox.totalBoxes <= truckSize) {
                truckSize -= curBox.totalBoxes;
                totalUnits += (curBox.unitsPerBox * curBox.totalBoxes);
            } else {
                totalUnits += (curBox.unitsPerBox * truckSize);
                truckSize = 0;
            }
            System.out.println(curBox);
            System.out.println("TS: " + truckSize + " , unit: " + totalUnits);
            curIndex++;
        }
​
        return totalUnits;
​
    }
}
​
