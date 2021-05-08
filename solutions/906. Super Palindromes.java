class Solution {
    
    public int superpalindromesInRange(String l, String r) {
        int superPalindrome = 0;
        Long left = (long) Math.sqrt(Long.parseLong(l));
        Long right = (Long.parseLong(r) / 2) * 1L;
        HashMap<Long, Boolean> cache = new HashMap<>();
        for (Long i = (long) 1; i < 10; i++) {
            if (i == 1 || i == 2 || i == 3) {
                cache.put(i * i, true);
            }
            cache.put(i, true);
        }
        for (Long i = left; i < right + 1; i++) { // 4 - 1000
            if (i < 10 && cache.containsKey(i*i) == true)
                superPalindrome++;
            else {
                if (cache.containsKey(i) == false) {
                    Long palindromeSquare = (long) Math.pow(i, 2); // 11 - 121
                    if (palindromeSquare <= right) {
                        if (isPalindromeSlow(i) && isPalindromeSlow(palindromeSquare)) {
                            superPalindrome++;
                            cache.put(i, true);
                            cache.put(palindromeSquare, true);
                        }
                    } else
                        break;
                }
            }
        }
​
        return superPalindrome;
    }
    private boolean isPalindromeSlow(Long num) {
        // TODO Auto-generated method stub
        String s = "" + num;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        String t = sb.toString();
        return s.equals(t);
    }
}
