public class Solution {
​
    private final int base = 256; // Base for the rolling hash (e.g., 256 for ASCII)
    private final int MOD = 101; // A prime number for modulo to avoid overflow
    
    public int strStr(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();
        
        // Edge case: if pattern is empty, return 0
        if (m == 0) return 0;
        
        // Edge case: if pattern is longer than the string, return -1
        if (m > n) return -1;
        
        // Compute the initial hash for the pattern and the first window of the string
        int patternHash = computeHash(pattern, m);
        int currentHash = computeHash(str, m);
        
        // Precompute base^(m-1) % MOD, used in rolling hash updates
        int highestBasePower = precomputeBasePower(m);
        
        // Slide the window over the string
        for (int i = 0; i <= n - m; i++) {
            // If the hash values match, check for the actual substring
            if (patternHash == currentHash && str.substring(i, i + m).equals(pattern)) {
                return i; // Match found at index i
            }
            
            // Compute the hash for the next window, if still within bounds
            if (i < n - m) {
                currentHash = updateRollingHash(currentHash, str.charAt(i), str.charAt(i + m), highestBasePower);
            }
        }
        
        return -1; // No match found
    }
​
    // Function to compute the initial hash of the first 'm' characters of a string
    private int computeHash(String s, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (base * hash + s.charAt(i)) % MOD;
        }
        return hash;
    }
​
