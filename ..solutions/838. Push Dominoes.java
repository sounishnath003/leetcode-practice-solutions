class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
​
        // we have to construct array of forces for each domino
        // if +ve -ve or 0
        // +ve --> right
        // -ve --> left
        // 0 --> do nothing || stand still
​
        final int n = dominoes.length();
        int[] forces = new int[n];
​
        // calculate forces for right and left
        // building the answer string
        calculateRightForces(dominoes, n, forces);
        calculateLeftForces(dominoes, n, forces);
        buildOutputString(sb, forces);
​
​
        return sb.toString();
    }
​
    private void buildOutputString(StringBuilder sb, int[] forces) {
        for (int force : forces) {
            if (force > 0) {
                sb.append('R');
            } else if (force < 0) {
                sb.append('L');
            } else {
                sb.append('.');
            }
        }
    }
​
    private void calculateLeftForces(String dominoes, final int n, int[] forces) {
        int current_force = 0;
        // left force calculation
        for (int i = n - 1; i >= 0; i--) {
            char c = dominoes.charAt(i);
            if (c == 'L')
                current_force = n;
            else if (c == 'R')
                current_force = 0;
            else {
                current_force = Math.max(current_force - 1, 0);
            }
            forces[i] -= current_force;
        }
    }
​
    private void calculateRightForces(String dominoes, final int n, int[] forces) {
        int current_force = 0;
        // // right force calculation
        for (int i = 0; i < n; i++) {
            char c = dominoes.charAt(i);
            if (c == 'R')
                current_force = n; // "R.......R" --> "RRRRRRRRR" mane sobai k fele debe right e
            else if (c == 'L')
                current_force = 0; // "L.......L" --> "LLLLLLLLL" mane sobai k fele debe left e
            else {
                current_force = Math.max(current_force - 1, 0);
                // current_force = 0;
                // if (i > 0) {
                // if (dominoes.charAt(i - 1) == 'R') current_force = n;
                // else if (dominoes.charAt(i - 1) == 'L') current_force = -n;
                // }
            }
            forces[i] += current_force;
        }
    }
}
