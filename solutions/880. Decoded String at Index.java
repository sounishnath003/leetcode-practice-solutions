class Solution {
    public String decodeAtIndex(String s, int K) {
          if (s.length()==0) {
            return null;
        }
​
        long size = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                size = size * (c-'0');
            }else {size++ ;}
        }
        System.out.println("Size of the string : " + size);
​
        char[] carray = s.toCharArray();
        for (int index = carray.length-1; index >= 0; index--) {
            char x = carray[index];
            System.out.print(x);
            K %= size;
            if ((K==0 || K==size) && Character.isLetter(x)) {
                return Character.toString(x) ;
            } else if (Character.isDigit(x)) {
                size = size / (x-'0');
            } else {
                size-- ;
            }
        }
        return null;
    }
}
