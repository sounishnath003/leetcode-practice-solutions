// """
// # _* coding: utf8 *_
​
// filename: Solution.java
​
// @author: sounishnath
// createdAt: 2023-03-23 07:02:33
// """
​
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int flowers) {
        int length = flowerbed.length;
        int unoccupiedPlace = 0;
        for (int i = 0; i < length; i++) {
            if (isEmpty(flowerbed[i])) {
                int previous = (i == 0 || isEmpty(flowerbed[i - 1])) ? 0 : 1;
                int next = (i == length - 1 || isEmpty(flowerbed[i + 1])) ? 0 : 1;
                if (isEmpty(previous) && isEmpty(next)) {
                    unoccupiedPlace++;
                    flowerbed[i]=1;
                }
            }
        }
​
        return unoccupiedPlace >= flowers;
    }
​
    private boolean isEmpty(int i) {
        return i == 0;
    }
}
