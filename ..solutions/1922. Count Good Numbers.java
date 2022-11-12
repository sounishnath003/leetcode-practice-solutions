class Solution {
    private long odd;
    private long even;
    private int inf = (int) 1_000_000_007;
​
    long m = (int)1e9+7;
    public int countGoodNumbers(long n) {
        return (int)(helper(5, (n + 1) / 2) * helper(4, n / 2) % m);    
    }
    long helper(long x,long y){
        if(y == 0)return 1;
        if(y%2 == 0)return helper((x*x) % m,y/2);
        else return (x * helper((x*x) % m,(y-1)/2)) % m;
    }
    
    // wrong solution
    public int countGoodNumbers2(long n) {
        int count = 0;
        for (long i = 1; i <= n; i++) {
            if (isGoodNumber(i)) {
                count = count++ % (1_000_000_007 + 7);
            }
        }
        return count;
    }
​
    private boolean isGoodNumber(long i) {
        int length = (int) Math.log10(i) + 1;
        int[] digits = new int[length];
        int count = 0;
        for (int j = 0; j < length; j++) {
            digits[j] = (int) (i % 10);
            i /= 10;
            if (digits[j] % 2 == 0) {
                count++;
            }
            if (digits[j] == 2 || digits[j] == 3 || digits[j] == 5 || digits[j] == 7) {
                count++;
            }
        }
        return count % 2 == 0;
    }
}
