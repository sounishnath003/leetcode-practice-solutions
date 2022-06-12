class Solution {
    public boolean strongPasswordCheckerII(String password) {
        int n=password.length();
        if (n<8)
            return false;
        boolean lower=false, upper=false, digit=false,special=false;
        String special_chars="!@#$%^&*()-+";
        for (char c : password.toCharArray()) {
            if (c >= 'A' && c <= 'Z') upper=true;
            if (c >= 'a' && c <= 'z') lower=true;
            if (c >= '0' && c <= '9') digit=true;
            for (char sp : special_chars.toCharArray())
                if (c == sp) {
                    special = true;
                    break;
                }
        }
        if (!lower || !upper || !digit || !special) return false;
        
        for (int i=1;i<n;i++){
            if (password.charAt(i)==password.charAt(i-1)) return false;
        }
        return true;
    }
}
