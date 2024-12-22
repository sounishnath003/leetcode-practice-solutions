class Solution {
    public int minDistance(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        
        // int[][] dp = new int[sn+1][tn+1];
        int[] prev=new int[tn+1];
        int[] cur=new int[tn+1];
        
        // define base case
        for (int i = 0; i < sn + 1; i++) {
            cur[0] = i;
        }
        for (int j = 0; j < tn + 1; j++) {
            prev[j] = j;
        }
        
        // fill dp
        for (int i=1; i < sn+1; i++) {
            cur[0]=i;
            for (int j=1; j < tn+1; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)) {
                    cur[j]=prev[j-1];
                } else {
                    int op1 = prev[j]; // delete
                    int op2 = cur[j - 1]; // insert
                    int op3 = prev[j - 1]; // replace
                    cur[j] = 1 + Math.min(op1, Math.min(op2, op3));
                }
            }
            prev=cur.clone();
        }
        
        return prev[tn];
    }
}
