class Solution {
    // https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/
    public List<String> maxNumOfSubstrings(String s) {
        HashMap<Character, Integer> first = new HashMap<>();
        HashMap<Character, Integer> last = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!first.containsKey(c)) {
                first.put(c, i);
            }
            last.put(c, i);
        }

        List<int[]> intervals = new ArrayList<>();
        for (char c : first.keySet()) {
            int l = first.get(c);
            int r = last.get(c);
            int i = l;
            while (i <= r) {
                if (first.get(s.charAt(i)) < l) {
                    l = first.get(s.charAt(i));
                    i = l;
                    continue;
                } else if (last.get(s.charAt(i)) > r) {
                    r = last.get(s.charAt(i));
                    i = l;
                    continue;
                }
                i++;
            }
            intervals.add(new int[] { l, r });
        }

        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> result = new ArrayList<>();
        int end = -1;
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            if (l > end) {
                result.add(s.substring(l, r + 1));
                end = r;
            }
        }

        return result;
    }

}