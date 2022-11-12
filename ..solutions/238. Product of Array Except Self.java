class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
​
        int[] leftwall = new int[n];
        leftwall[0]=nums[0];
        for (int i = 1; i < n; i++) {
            leftwall[i] = leftwall[i-1] * nums[i];
        }
​
        int[] rightwall = new int[n];
        rightwall[n-1]=nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightwall[i] = rightwall[i+1] * nums[i];
        }
​
        // System.out.println("leftwall = " + Arrays.toString(leftwall));
        // System.out.println("rightwall = " + Arrays.toString(rightwall));
​
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (i==0) {
                result[i] = rightwall[i+1];
            } else if (i == n-1) {
                result[i] = leftwall[i-1];
            } else {
                int leftp = leftwall[i-1];
                int rightp = rightwall[i+1];
​
                result[i] = leftp * rightp;
            }
        }
​
        return result;
    }
}
