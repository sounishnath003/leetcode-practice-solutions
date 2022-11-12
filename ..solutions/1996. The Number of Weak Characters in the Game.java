class Solution {
    private static class Pair {
        int attack;
        int defense;
​
        public Pair(int attack, int defense) {
            this.attack = attack;
            this.defense = defense;
        }
​
        @Override
        public String toString() {
            return "Pair [attack=" + attack + ", defense=" + defense + "]";
        }
    }
​
    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        Pair[] characters = new Pair[n];
        for (int i = 0; i < n; i++) {
            characters[i] = new Pair(properties[i][0], properties[i][1]);
        }
        int weak_characters = 0;
        Arrays.sort(characters, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.attack == b.attack) {
                    return a.defense - b.defense;
                }
                return b.attack - a.attack;
            }
        });
        int current_max_defence = 0;
        for (Pair pair : characters) {
            if (current_max_defence > pair.defense)
                weak_characters++;
            current_max_defence = Math.max(current_max_defence, pair.defense);
        }
​
        return weak_characters;
    }
}
