class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int elem1 = -1;
        int elem2 = -1;
        int count1 = 0;
        int count2 = 0;
​
        for (int elem : nums) {
            if (elem == elem1)
                count1++;
            else if (elem == elem2)
                count2++;
            else if (count1 == 0) {
                count1 = 1;
                elem1 = elem;
            } else if (count2 == 0) {
                count2 = 1;
                elem2 = elem;
            } else {
                count1--;
                count2--;
            }
        }
​
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == elem1)
                count1++;
            if (num == elem2)
                count2++;
        }
​
        int length = nums.length;
        List<Integer> result = new ArrayList<>();
​
        if (count1 > length / 3)
            result.add(elem1);
​
        if (elem1 != elem2 && count2 > length / 3)
            result.add(elem2);
​
        return result;
    }
}
