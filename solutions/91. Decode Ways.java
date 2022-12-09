class Solution {
    public int numDecodings(String s) {
        /*
         * 224 2, 2, 4 22, 4 2, 24
         * 
         * f[i] ---> f[i-1] + s[i-1][i] (1) if < 26 + s[i] (1)
         */
//          return _func(s.toCharArray(), 0);
​
        final int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
​
        for (int i = 2; i < dp.length; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            int two = Integer.valueOf(s.substring(i - 2, i));
            System.out.println("one=" + one + ", two=" + two);
            if (one > 0) {
                dp[i] += dp[i - 1];
            }
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
​
        return dp[n];
    }
​
    private int _func(char[] charArray, int curindex) {
        if (curindex == charArray.length)
            return 1;
​
        int onedigit = toNumber("" + charArray[curindex]);
        if (onedigit == 0)
            return 0;
        int count = _func(charArray, curindex + 1);
        if (curindex + 1 < charArray.length) {
            int twodigit = toNumber("" + charArray[curindex] + charArray[curindex + 1]);
            if (twodigit >= 10 && twodigit < 27) {
                count += _func(charArray, curindex + 2);
            }
        }
​
        return count;
    }
​
    private int toNumber(String string) {
        // TODO Auto-generated method stub
        return (int) Integer.parseInt(string);
    }
}
​
