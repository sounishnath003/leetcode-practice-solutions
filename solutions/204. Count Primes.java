class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if(isPrime[i]==false) continue;
            else {
                for (int j = i * i; j < n; j +=i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (boolean x : isPrime) {
            if (x==true) count++;
        }
        return count-2;
    }
}
