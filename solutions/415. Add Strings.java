class Solution {
    public String addStrings(String num1, String num2) {
        char[] arr1 = reverse(num1.toCharArray());
        char[] arr2 = reverse(num2.toCharArray());
​
        int n = (arr1.length > arr2.length) ? arr1.length : arr2.length;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
​
        for (int i = 0; i < n; i++) {
            int elem1 = (i < arr1.length) ? toNumber(arr1[i]) : 0;
            int elem2 = (i < arr2.length) ? toNumber(arr2[i]) : 0;
            int total = elem1 + elem2 + carry;
​
            if (total >= 10) {
                carry = 1;
                total = total - 10;
            } else {
                carry = 0;
            }
​
            sb.append(total);
        }
        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
​
    private char[] reverse(char[] arr) {
        // TODO Auto-generated method stub
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            char c = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = c;
            lo++;
            hi--;
        }
        return arr;
    }
​
    private int toNumber(char x) {
        return (int) (x - '0');
    }
}
​
