// https://leetcode.com/problems/find-all-anagrams-in-a-string/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
​
            List<Integer> answer = new ArrayList<Integer>();
            if (s.length() < p.length() ) return answer;
​
            Map<Character, Integer> pmap = new HashMap<>();
            for (Character c : p.toCharArray())
                pmap.put(c, pmap.getOrDefault(c, 0)+1);
​
            int start = 0;
            int end = 0;
​
            Map<Character, Integer> smap = new HashMap<>();
​
            while (end < s.length()) {
                char c = s.charAt(end);
                smap.put(c, smap.getOrDefault(c, 0) + 1);
​
                int windowSize = end - start + 1;
                if (windowSize == p.length()) {
                    // check if two maps are equal
                    if ( pmap.equals(smap)) {
                        answer.add(start);
                    }
                    // decrease the count for s[start]
                    int ppcount = smap.get(s.charAt(start));
                    // if the ppcount - 1 == 0 remove it out
                    if (ppcount - 1 == 0) {
                        smap.remove(s.charAt(start));
                    } else {
                        smap.put( s.charAt(start), ppcount - 1);
                    }
​
                    start++;
                }
                end++;
            }
​
​
            return answer;
    }
}   
