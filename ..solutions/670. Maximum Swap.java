class Solution {
    public int maximumSwap(int num) {
        StringBuilder answer = new StringBuilder("" + num);
​
        int i = 0;
        int j = answer.length() - 1;
        int max_ = -1;
        int id_ = -1;
        int id__ = 0;
​
        while (j > i) {
            int digit = answer.charAt(j) - '0';
            int self = answer.charAt(i) - '0';
​
            if (digit > self && digit > max_) {
                max_ = digit;
                id_ = j;
                id__ = i;
            }
            j--;
            if (j == i && id_ == -1) {
                i++;
                j = answer.length() - 1;
            }
        }
        if (id_ != -1) {
            System.out.println(id__ + " " + id_);
            char t = answer.charAt(id__);
            answer.setCharAt(id__, answer.charAt(id_));
            answer.setCharAt(id_, t);
        }
​
        return Integer.parseInt(answer.toString());
    }
}
