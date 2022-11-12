class Solution {
    // Time. O(NlogN + N * N) => O(N^2)
    // Space. O(N)
    public List<List<String>> suggestedProducts2(String[] products, String searchWord) {
        Arrays.sort(products, String.CASE_INSENSITIVE_ORDER);
​
        List<List<String>> suggestedList = new ArrayList<>();
​
        for (int i = 0; i < searchWord.length(); i++) {
            String searchTerm = searchWord.substring(0, i + 1);
​
            List<String> matchedWords = Arrays.stream(products).filter(word -> word.contains(searchTerm))
                    .collect(Collectors.toList());
​
            if (matchedWords.size() > 3)
                suggestedList.add(matchedWords.subList(0, 3));
            else
                suggestedList.add(matchedWords);
        }
​
        return suggestedList;
    }
​
    // Time. O(NlogN + O(n`logn)) ~~> O(n`log(n`)) ~~> O(m^2)[I might -> Java]
    // Space. O(N)
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products, String.CASE_INSENSITIVE_ORDER);
        
        List<List<String>> suggestedList = new ArrayList<>();
​
        final int n = products.length;
        int lo = 0;
        int hi = n - 1;
​
        for (int i = 0; i < searchWord.length(); i++) {
            char currChar = searchWord.charAt(i);
​
            while ((lo <= hi) && (products[lo].length() <= i || products[lo].charAt(i) != currChar)) {
                // word take consider korbo na!
                lo++;
            }
​
            while ((lo <= hi) && (products[hi].length() <= i || products[hi].charAt(i) != currChar)) {
                // same hi word takeo consider korbo na
                hi--;
            }
​
            int min = Math.min(lo + 3, hi + 1);
            List<String> curListAns = new ArrayList<>();
            for (int j = lo; j < min; j++) {
                curListAns.add(products[j]);
            }
​
            suggestedList.add(curListAns);
        }
​
        return suggestedList;
    }
}
