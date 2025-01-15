class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // length.
        int n = arr1.length;
        Set<Integer> set=new HashSet<>();
        // iterate and create prefix substrings
        for (int i = 0; i < n; i++) {
            // split the numbers and insert
            int num=arr1[i];
            while(num > 0) {
                set.add(num);
                num = num / 10; // pick each digit
            }
        }

        System.out.println(set);

        // iterate on the arr2 and check the existence
        int found=0;
        // length2.
        int m=arr2.length;
        for (int i =0; i < m; i++) {
            int num=arr2[i];
            while(num > 0) {
                if (set.contains(num)) {
                    found = Math.max(found, String.valueOf(num).length());
                    break;
                }
                // split the digits
                num = num / 10;
            }
        }

        return found;
    }
}