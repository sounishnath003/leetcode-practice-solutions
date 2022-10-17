class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();   
        for (char c : sentence.toCharArray()) set.add(c);
        return set.size() == ( (int) ('z') -  (int)('a') + 1);
    }
}
