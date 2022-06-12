class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        boolean[][] table=new boolean[256][256];
        for (int i=0;i< table.length;i++) table[i][i]=true;
        for (char[] map:mappings){
            int mapi=map[0];
            int mapj=map[1];
            table[mapi][mapj]=true;
        }
        
        int n=s.length();
        int m=sub.length();
        for (int i=0;i<n-m+1;i++){
            // substring S[i:i+m+1]
            String s_substring=s.substring(i,i+m);
            boolean was_done=true;
            for (int j=0;j<m;j++){
                int index_1=s_substring.charAt(j);
                int index_2=sub.charAt(j);
                if (!table[index_2][index_1]) {
                    was_done=false;
                    break;
                }
            }
            if (was_done)
                return true;
        }
        return false;
    }
}
