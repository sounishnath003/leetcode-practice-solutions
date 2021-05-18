class Solution {
    private List<List<Integer>> edges = new ArrayList<>();
    int[] score;
​
    public int longestStrChain(String[] words) {
        final int n = words.length;
        
        // Reformatting storage
        for (int i = 0; i < n; i++)
            edges.add(new ArrayList<Integer>());
        score = new int[n];
​
        LinkedHashMap<String, Integer> cacheIndices = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            cacheIndices.put(words[i], i);
        }
​
        for (int i = 0; i < n; i++) {
            String s = words[i];
            for (int j = 0; j < s.length(); j++) {
                // delete s[j] char
                String maybe = s.substring(0, j) + s.substring(j + 1);
                if (cacheIndices.containsKey(maybe)) {
                    int keyIndex = cacheIndices.get(maybe);
                    this.edges.get(keyIndex).add(i);
                }
            }
        }
        
        int potentialLongest = 0;
        for (int i = 0; i < n; i++)
            potentialLongest = Math.max(potentialLongest, this.longest(i));
​
        return potentialLongest;
    }
​
    private int longest(int v) {
        // TODO Auto-generated method stub
        
        if(this.score[v] > 0)
            return this.score[v];
        
        this.score[v]=1;
        for(Integer b : edges.get(v))
            this.score[v] = Math.max(this.score[v], this.longest(b)+1);
        
        return this.score[v];
    }
}
