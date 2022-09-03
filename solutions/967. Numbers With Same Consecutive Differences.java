class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), n, k, true);
        int[] res = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            res[i] = Integer.parseInt(result.get(i));
        }
        return res;
    }
    private void backtrack(List<String> result, StringBuilder sb, int n, int k, boolean firstZero){
        if(sb.length() == n){
            StringBuilder copy = new StringBuilder(sb);
            result.add(copy.toString());
            return;
        }
        for(int i=0; i<=9; i++){
            if(i == 0 && firstZero) continue;
            else{
                if(sb.length() == 0){
                    sb.append(i);
                    backtrack(result, sb, n, k, false);
                    sb.deleteCharAt(sb.length()-1);
                }
                else{
                    int lastChar = sb.charAt(sb.length()-1) - '0';
                    if(Math.abs(i - lastChar) == k){
                        sb.append(i);
                        backtrack(result, sb, n, k, false);
                        sb.deleteCharAt(sb.length()-1);
                    }
                }
            }
        }
    }
}
