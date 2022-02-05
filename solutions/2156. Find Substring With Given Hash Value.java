/**
 * @author sounishnath
 *
 */
class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        // sliding window with k
        
        long hashcode = 0;
        long powerk = 1;
        int result = 0;
        int n = s.length();
        
        for (int i = n - 1; i >= 0; i--) {
            hashcode = (hashcode  * power + s.charAt(i) - 'a' + 1 ) % modulo;
            if (i + k >= n) {
                powerk = powerk * power % modulo;
            } else {
                hashcode =  (hashcode - (s.charAt(i + k) - 'a' + 1) * powerk % modulo + modulo) % modulo;
            }
            
            if (hashcode == hashValue) {
                result = i;
            }
        }
        
        return s.substring(result, result + k);
    }
​
    private int computeHash(String s, int power, int modulo) {
        int code = 0;
        for (int i = 0; i < s.length(); i++) {
            int charcode = (s.charAt(i) - 'a') + 1;
            int value = (charcode * (int) Math.pow(power, i));
            code += value;
            code = code % modulo;
        }
​
        return code;
    }
​
}
