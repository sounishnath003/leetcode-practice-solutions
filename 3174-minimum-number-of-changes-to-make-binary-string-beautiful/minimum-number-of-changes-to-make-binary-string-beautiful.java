class Solution {
    public int minChanges(String s) {
        int changes=0;

        for (int i = 0; i < s.length(); i+=2) {
            char ai = s.charAt(i);
            char bi = s.charAt(i+1);
            if (ai != bi) changes++;
        }

        return changes;
    }
}