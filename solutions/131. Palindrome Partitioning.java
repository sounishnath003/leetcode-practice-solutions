class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>result=new ArrayList<>();
        List<String>set=new ArrayList<>();
        func(s,0,set,result);
        return result;
    }
​
    private void func(String s, int current_index, List<String> set, List<List<String>> result) {
        if (current_index>=s.length()){
            result.add(new ArrayList<>(set));
            return;
        }
        for (int i=current_index;i<s.length();i++){
            if (is_palindrome(s,current_index,i)){
                set.add(s.substring(current_index,i+1));
                func(s,i+1,set,result);
                set.remove(set.size()-1);
            }
        }
    }
​
    private boolean is_palindrome(String s, int start, int end) {
        while (start<end){
            if (s.charAt(start)!=s.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }
}
