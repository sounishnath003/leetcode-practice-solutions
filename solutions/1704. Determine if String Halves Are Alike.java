class Solution {
    public boolean halvesAreAlike(String s) {
        s=s.toLowerCase();
        int n=s.length();
        int mid=n/2;
        String part1=s.substring(0, mid);
        String part2=s.substring(mid, n);
        System.out.println("p=" + part1 + ", q=" + part2);
        return (isAlike(part1, part2));
    }
​
    private boolean isAlike(String part1, String part2) {
        // TODO Auto-generated method stub
        if (part1.length() != part2.length())
            return false;
        int avowelscount = countVowels(part1);
        int bvowelscount = countVowels(part2);
        return avowelscount == bvowelscount;
    }
​
    private int countVowels(String s) {
        // TODO Auto-generated method stub
        char[] letters = s.toCharArray();
        int count = 0;
        for (char letter : letters) {
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                count++;
            }
        }
        return count;
    }
}
​
