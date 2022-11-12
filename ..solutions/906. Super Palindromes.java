class Solution {
    // Hopefully Working!! Phewwwww!
    public int superpalindromesInRange(String left, String right) {
        List<Long> palindromicNo = new ArrayList<>();
        Long leftNo = Long.parseLong(left);
        Long rightNo = Long.parseLong(right);
        int count = 0;
        for(long i= 1;i<10;i++){
            palindromicNo.add(i);
        }
        for(long i=1;i<10000;i++){
            String leftPart = Long.toString(i);
            String rightPart = new StringBuilder(leftPart).reverse().toString();
​
            palindromicNo.add(Long.parseLong(leftPart+rightPart));
​
            for(int digit=0;digit<10;digit++){
                palindromicNo.add(Long.parseLong(leftPart + digit + rightPart));
            }
        }
        for(long no : palindromicNo){
            long squareNo = no * no; // 10^18
            if(leftNo <= squareNo && rightNo >=squareNo &&  isPalindromic(Long.toString(squareNo))){
​
                count++;
            }
        }
        return count;
    }
​
     private boolean isPalindromic(String str){
        int start = 0;
        int end = str.length()-1;
        while(start< end){
            if(str.charAt(start)!= str.charAt(end)){
                return false;
            } else{
                start++;
                end--;
            }
        }
​
        return true;
    }
}
