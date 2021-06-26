        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                answer.add(0);
            } else
                answer.add(dp[i]);
        }
​
        return answer;
    }
​
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
​
        public String next() {
            while (!st.hasMoreElements())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
​
        int nextInt() {
            return Integer.parseInt(next());
        }
​
        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
​
        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
​
        long nextLong() {
            return Long.parseLong(next());
        }
    }
​
}
​
/*
 * TC:1 7 T P P P T T T 2
 * 
 * TC:2 10 P T T P P T T T T P 2
 */
