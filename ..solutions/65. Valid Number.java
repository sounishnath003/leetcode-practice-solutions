class Solution {
​
        boolean isdecimal(String s, int e, int sign, int d) {
​
            if (s.equals("") || s.equals("."))
                return false;
​
            if (s.startsWith("+") || s.startsWith("-")) {
                if (sign == 1) {
                    return false;
                }
                if (s.length() > 1) {
                    if (!(Character.isDigit(s.charAt(1)) || s.charAt(1) == '.'))
                        return false;
                }
                return isdecimal(s.substring(1), e, 1, d);
            }
​
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!Character.isDigit(ch)) {
                    if (ch == '.' && e == 1)
                        return false;
​
                    if (ch == '.') {
​
                        if (d == 1)
                            return false;
​
                        if (i == s.length() - 1)
                            return true;
​
                        if (i < s.length() - 1) {
                            if (!(Character.isDigit(s.charAt(i + 1)) || (s.charAt(i + 1) == 'e'
                                    && (i > 0 ? Character.isDigit(s.charAt(i - 1)) : false))))
                                return false;
                        }
​
                        return isdecimal(s.substring(i + 1), e, sign, 1);
                    }
