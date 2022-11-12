class Solution {
    // O N^2 Solution with Space - Constant
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        
        for (String word : words) {
            if (isSubsequence(s, word))
                count++;
        }
        
        return count;
    }
​
    private boolean isSubsequence(String s, String word) {
        // TODO Auto-generated method stub
        int prevChIndex = 0;
        
        for (char c : word.toCharArray()) {
            int index = s.indexOf(c, prevChIndex);
            if (index == -1) return false;
            prevChIndex = index+1;
        }
        
        return true;
    }
​
    // ~~~~~~~ SLOW Solution ->> EXOPENTIAL COMPLEXITY + SPACE 2^n ~~~~~~~~~~
    // ~~~~~~ Super BAD Super in TC ~~~~~~~~~~~~`
    public int numMatchingSubseq2(String s, String[] words) {
        List<String> subsequences = generateAllSubsequences(s);
        System.out.println(subsequences);
        Set<String> set = new HashSet<String>(subsequences);
        
        int found = 0;
        for (String word : words)
            if (set.contains(word)==true) found++;
        
        return found;
    }
​
    private List<String> generateAllSubsequences(String s) {
        // TODO Auto-generated method stub
        List<String> answers = new ArrayList<String>();
        answers = _generateAllSubsequences(s);
        return answers;
    }
​
    private List<String> _generateAllSubsequences(String s) {
        // TODO Auto-generated method stub
​
        if (s.length() == 0) {
            List<String> bres = new ArrayList<String>();
            bres.add("");
            return bres;
        }
​
        List<String> myres = new ArrayList<String>();
​
        char fc = s.charAt(0);
        String ros = s.substring(1);
​
        // faith
        List<String> rres = _generateAllSubsequences(ros);
        for (String r : rres) {
            myres.add(r);
            myres.add(fc + r);
        }
​
        return myres;
    }
}
