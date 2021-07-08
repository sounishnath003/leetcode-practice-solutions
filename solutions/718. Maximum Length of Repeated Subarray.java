// Maximum Length of Repeated Subarray
class Solution {
    
    public int findLength(int[] arr1, int[] arr2) {
        final int n = arr1.length;
        final int m = arr2.length;
        
        // easy trick will be treating the problem as a LCS problem.
        // apply that same stragey to this.
        
        // you will be good to go. 
        // Actually very easy
        
        int[][] dp = new int[n+1][m+1];
        int maxLen = 0;
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int elem1 = arr1[i-1];
                int elem2 = arr2[j-1];
                
                if (elem1 == elem2) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                maxLen = Math.max( maxLen, dp[i][j]);
            }
        }
        
        return maxLen;
    }
    
        public int findLength2(int[] arr1, int[] arr2) {
            HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
​
            for (int i = 0; i < arr1.length; i++) {
                int key = arr1[i];
                if (map.containsKey(key) == true) {
                    map.get(key).add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(key, list);
                }
            }
​
            System.out.println(map);
​
            // checking weither the length of the array subarray;
​
            int maxLength = 0;
​
            for (int i = 0; i < arr2.length; i++) {
                int key = arr2[i];
​
                // check if key presents in map
                if (map.containsKey(key) == true) {
                    int ii = i;
                    for (int jj : map.get(key)) {
                        while ((ii < arr2.length && jj < arr1.length) && arr2[ii] == arr1[jj]) {
                            ii++;
                            jj++;
                        }
                        ii--;
                        int len = Math.abs(ii - i);
                        maxLength = Math.max(len, maxLength);
                    }
                }
​
            }
​
            return maxLength;
        }
    }
​
