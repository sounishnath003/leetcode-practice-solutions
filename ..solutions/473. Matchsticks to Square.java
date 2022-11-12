class Solution {
    public boolean makesquare(int[] matchsticks) {
        final int n = matchsticks.length;
        if (n < 4)
            return false;
​
        int peri = 0;
        for (int x : matchsticks)
            peri += x;
​
        if (peri % 4 != 0)
            return false;
​
        int side = peri / 4;
        int[] sides = new int[] { side, side, side, side };
​
        return _makeSqaure(matchsticks, sides, 0);
    }
​
    private boolean _makeSqaure(int[] matchsticks, int[] sides, int i) {
        // TODO Auto-generated method stub
        if (i >= matchsticks.length) {
            boolean side1 = sides[0] == 0 && sides[2] == 0;
            boolean side2 = sides[1] == 0 && sides[3] == 0;
            return side1 && side2;
        }
​
        for (int j = 0; j < sides.length; j++) {
            if (matchsticks[i] > sides[j])
                continue;
            else {
                sides[j] -= matchsticks[i];
                // System.out.println("Pre: " + Arrays.toString(sides));
                if (_makeSqaure(matchsticks, sides, i + 1) == true)
                    return true;
                sides[j] += matchsticks[i];
                // System.out.println("Post: " + Arrays.toString(sides));
            }
        }
​
        return false;
    }
}
