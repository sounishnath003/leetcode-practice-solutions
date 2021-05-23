class Solution {
    
    private String mergeTwoStrings(String a, String b) {
        int n = a.length();
        int m = b.length();
        
        int overLapped1 = 0;
        int overLapped2 = 0;
        
        for(int i = 1; n - i >= 0 && i <= m; i++) {
            if(a.substring(n - i).equals(b.substring(0, i))) {
                overLapped1 = i;
            }
        }
        
        for (int i = 1; m - i >= 0 && i <= n; i++) {
            if (b.substring(m-i).equals(a.substring(0, i))) {
                overLapped2 = i;
            }
        }
        
        if (overLapped1 >= overLapped2)
            return b.substring(0, m - overLapped2) + a;
        
        return a.substring(0, n - overLapped1) + b;
    }
    
    public String shortestSuperstring(String[] words) {
        List<String> listsOfWords = new ArrayList<>(Arrays.asList(words));
                
        while(true) {
            int n = listsOfWords.size();
            if (n==1)
                break;
        
            int maxLength = -1;
            int index1 = 0;
            int index2 = 0;
            String answer = "";
            
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    String a = listsOfWords.get(i);
                    String b = listsOfWords.get(j);
                    
                    String mergedString = this.mergeTwoStrings(a, b);
                    int computedLength = a.length() + b.length() - mergedString.length();
                    if (computedLength < maxLength) {
                        maxLength = computedLength;
                        index1 = i;
                        index2 = j;
                        answer= mergedString;
                    }
                }
            }
            
            // remove the processed words and add newly mergedString
            String a = listsOfWords.get(index1);
            String b = listsOfWords.get(index2);
            
            listsOfWords.remove(a);
            listsOfWords.remove(b);
            listsOfWords.add(answer);
        }
        
        return listsOfWords.get(0);
    }
}
