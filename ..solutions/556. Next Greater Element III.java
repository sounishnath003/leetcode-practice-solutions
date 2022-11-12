class Solution {
  private int dipIndex(char[] arr) {
        int indx = arr.length - 2;
        while(indx >= 0 && (arr[indx] >= arr[indx + 1])) {
            indx--;
        }
        return indx;
    }
​
    private  int ceilIndex(char[] arr, int indx) {
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] > arr[indx]) {
                return i;
            }
        }
        return -1;
    } 
​
    private void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
​
    private void reverse(char[] arr, int indx) {
        int left = indx;
        int right = arr.length - 1;
        while(left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
    
    public String nextGreaterElement_(String str) {
        if(str.length() == 1) return "-1";
        char[] arr = str.toCharArray();
        int dipIndx = dipIndex(arr);
        if(dipIndx == -1) {
            return "-1";
        }
        int ceilIndx = ceilIndex(arr, dipIndx);
        swap(arr, dipIndx, ceilIndx);
        reverse(arr, dipIndx + 1);
        return String.valueOf(arr);
    }
​
​
​
    // for leetcode, above problem
    public int nextGreaterElement(int n) {
        String str = n + "";
        String res_ = nextGreaterElement_(str);
        long res = Long.parseLong(res_);
        if(res <= Integer.MAX_VALUE) {
            return (int)res;
        } else {
            return -1;
        }
    }
}
