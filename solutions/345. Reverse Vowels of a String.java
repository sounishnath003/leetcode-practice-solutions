class Solution {
    private boolean isVowel(char ch) {
        String vowels = "aeiouAEIOU";
        return vowels.contains(ch + "");
    }
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
​
        int left = 0;
        int right = arr.length - 1;
​
        while(left < right) {
            // make left pointer at vowel
            while(left < right && isVowel(arr[left]) == false) {
                left++;
            }
​
            // make right pointer at vowel
            while(left < right && isVowel(arr[right]) == false) {
                right--;
            }
​
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
​
            left++;
            right--;
        }
​
        return String.valueOf(arr);
    }
}
