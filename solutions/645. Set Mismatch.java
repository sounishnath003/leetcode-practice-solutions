    class Solution {
        public int[] findErrorNums(int[] nums) {
            /**
             * Simple using Maths:
             * ----------------------
             * [1,2,2,4]
             * 1+2+3+4 = 10 (naturalSum)
             * 1+2+2+4 = 9 (currentSum)
             * --------------
             * duplicate = 2
             * missing = (naturalSum + duplicate - currentSum)
             * 
             * Using Bit Operation:
             * ----------------------
             * use HashSet to store the numbers && xor = xor ^ number
             * if number is in hashset duplicate = number
             * 
             * for (i=1 to arr.length) {
             * xor = xor ^ i
             * }
             * 
             * return {duplicate, xor};
             * 
             */
​
            int currentSum = Arrays.stream(nums).sum();
            int naturalSum = ((nums.length) * (nums.length + 1)) / 2;
​
            int duplicate = -1;
            Set<Integer> set = new HashSet<>();
            for (int x : nums) {
                if (set.contains(x)) {
                    duplicate = x;
                } else {
                    set.add(x);
                }
            }
​
            int missing = (naturalSum + duplicate - currentSum);
            return new int[] { duplicate, missing };
        }
    }
