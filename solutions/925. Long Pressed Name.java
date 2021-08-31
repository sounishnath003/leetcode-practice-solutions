class Solution {
    public boolean isLongPressedName(String name, String typed) {
        return isPossible(name, typed);
    }
    
​
  public boolean isPossible(String name, String typed) {
    int i = 0;
    int j = 0;
​
    if (name.charAt(0) != typed.charAt(0)) return false;
​
    i++;
    j++;
​
​
    while (i < name.length() && j < typed.length()) {
      if (isEqual(name, typed, i, j)) {
        i++;
        j++;
      } else if (0 <= i - 1 && isEqual(name, typed, i - 1, j)) {
        j++;
      } else {
        return false;
      }
    }
    
    while (j < typed.length()) {
        if ( isEqual(name, typed, i-1, j)) j++;
        else return false;
    }
​
    return i == name.length();
  }
​
  private boolean isEqual(String name, String typed, int i, int j) {
    return name.charAt(i) == typed.charAt(j);
  }
​
}
