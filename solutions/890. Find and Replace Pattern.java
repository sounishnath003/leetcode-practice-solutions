class Solution {
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        /*
            * Question is fairly easy to solve
            * Think that way.
            * First generate and number pattern using hasmap.put(key, index++)
            * iterate all words and generate patternforcurrent word
            * and just compare using 
            * patternWordPermutation.equals(currwordPattern)
        */
        
        List<String> foundWords = new ArrayList<>();
        String patternPermutationString = this.generatePermutationString(pattern);
        // cheeck locally
        System.out.println(patternPermutationString);
        // iterate over all words
        for(String word : words) {
            if (word.length() == pattern.length()) {
                String currentWordPermutation = this.generatePermutationString(word);
                if (patternPermutationString.equals(currentWordPermutation)==true) {
                    foundWords.add(word);
                }
            }
        }
​
        return foundWords;
    }
​
    private String generatePermutationString(String pattern) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int index = 0;
        StringBuilder permutationString = new StringBuilder();
​
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            if (hashMap.containsKey(key) == false) {
                index++;
                hashMap.put(key, index);
            }
            permutationString.append(hashMap.get(key));
        }
        
        return permutationString.toString();
    }
​
}
