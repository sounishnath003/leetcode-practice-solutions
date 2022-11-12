class Solution {
    private int globalMaxlength = 0;
​
    public int maxLength(List<String> arr) {
        if (arr.size() == 0 || arr == null)
            return 0;
​
        this._maxlength(arr, "", 0);
        return globalMaxlength;
    }
​
    private int _maxlength(List<String> arr, String asf, int curindex) {
        boolean isUniq = this.isAllCharactersUniq(asf, "");
        if (!isUniq) {
            return 0;
        }
​
        globalMaxlength = Math.max(globalMaxlength, asf.length());
        for (int i = curindex; i < arr.size(); i++) {
            String t = arr.get(i);
            this._maxlength(arr, asf + t, i + 1);
        }
​
        return globalMaxlength;
    }
​
    public int maxLength2(List<String> arr) {
        if (arr.size() == 1) {
            if (isAllCharactersUniq(arr.get(0), "")) {
                return arr.get(0).length();
            }
        }
​
        int globalMaxlength = 0;
        for (int i = 0; i < arr.size(); i++) {
            StringBuilder sb = new StringBuilder(arr.get(i));
            if (isAllCharactersUniq(sb.toString(), "")) {
                globalMaxlength = Math.max(globalMaxlength, sb.length());
            }
            for (int j = i + 1; j < arr.size(); j++) {
                String candidate = arr.get(j);
                if (isAllCharactersUniq(sb.toString(), candidate)) {
                    sb.append(candidate);
                    System.out.println(sb.toString());
                    globalMaxlength = Math.max(globalMaxlength, sb.length());
                }
            }
        }
        return globalMaxlength;
    }
​
    private boolean isAllCharactersUniq(String s, String candidate) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray())
            set.add(c);
        for (char c : candidate.toCharArray())
            set.add(c);
​
        int finalStringLength = s.length() + candidate.length();
​
        return set.size() == finalStringLength;
    }
}
​
