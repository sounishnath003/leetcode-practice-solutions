class Solution {
    public String minWindow(String s, String t) {
        return this.miniWindowSubstring(s, t);
    }
    
    private String miniWindowSubstring(String s, String p) {
        /**
         * in this problem the problem is we donot know what will be the window length
         * as its a dynamic / variable size window problem.
         * 
         * thr trick is always for such kind of problem check how many characters were matched?.
         * that is going to be your first Window
         */
        int[] sfreq = new int[256];
        int[] pfreq = new int[256];
​
        for (int c : p.toCharArray()) {
            pfreq[c]++;
        }
​
        int start = 0;
​
        int cnt = 0;
        int start_idx = -1;
        int maxLength = Integer.MAX_VALUE;
​
        for (int end = 0; end < s.length(); end++) {
            int schar = s.charAt(end);
            sfreq[schar]++;
            // count of chars matched with `p` so far
            if (pfreq[schar] != 0 && sfreq[schar] <= pfreq[schar]) {
                cnt++;
            }
​
            if (cnt == p.length()) {
                // start reducing the curr window
                while (pfreq[s.charAt(start)] == 0 || sfreq[s.charAt(start)] > pfreq[s.charAt(start)]) {
                    sfreq[s.charAt(start)]--;
                    start++;
                }
​
                int windowLength = end - start + 1;
                if (windowLength < maxLength) {
                    start_idx = start;
                    maxLength = windowLength;
                }
            }
        }
​
        if (start_idx == -1) {
            System.out.println("no window found");
            return "";
        }
​
        String answer = s.substring(start_idx, start_idx + maxLength);
        return answer;
    }
​
    private String minimumWindowSubstring(String s, String p, int start, int end) {
        if (s.length() < p.length())
            return "";
