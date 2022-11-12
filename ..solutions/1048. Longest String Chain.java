class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Map<String,Integer> map=new HashMap<>(); // <word, word_length>
        int result=0;
        for (String word : words) {
            // generate the substrings
            for (int j = 0; j < word.length(); j++) {
                String sub_word = word.substring(0, j) + word.substring(j + 1);
                map.put(word, Math.max(map.getOrDefault(word, 0), map.getOrDefault(sub_word,0) + 1));
            }
            result=Math.max(result, map.get(word));
        }
        return result;
    }
}
