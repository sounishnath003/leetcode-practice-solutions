class Solution {
    public boolean isPossible(int[] target) {
        while (isAllElementsAreOne(target) == false) {
            int[] maxEle = getMaxElement(target); // [idx, el]
            int subtract = subtractFromAllElements(target, maxEle);
            if (subtract < 1)
                return false;
            target[maxEle[0]] = 1;
        }
        return true;
    }
​
    private int subtractFromAllElements(int[] target, int[] max) {
        // TODO Auto-generated method stub
        int sub = max[1];
        for (int i = 0; i < target.length; i++) {
            if (max[0] != i) sub -= target[i];
        }
        return sub;
    }
​
    private int[] getMaxElement(int[] target) {
        // TODO Auto-generated method stub
        int max = Integer.MIN_VALUE;
        int id = -1;
        for (int i = 0; i < target.length; i++) {
            if (max < target[i]) {
                max = target[i];
                id = i;
            }
        }
        return new int[] { id, max };
    }
​
    private boolean isAllElementsAreOne(int[] target) {
        // TODO Auto-generated method stub
        for (int x : target) {
            if (x != 1)
                return false;
        }
        return true;
    }
    
}
