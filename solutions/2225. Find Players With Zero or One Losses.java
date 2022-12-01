class Solution {
    private class MatchInfo {
        int winner;
        int losser;
​
        public MatchInfo(int winner, int losser) {
            super();
            this.winner = winner;
            this.losser = losser;
        }
​
        @Override
        public String toString() {
            return "MatchInfo [winner=" + winner + ", losser=" + losser + "]";
        }
    }
​
    private class MatchResult {
        public List<Integer> allWinners;
        public List<Integer> oneLosses;
​
        public MatchResult() {
            // TODO Auto-generated constructor stub
            this.allWinners = new ArrayList<>();
            this.oneLosses = new ArrayList<>();
        }
​
        public List<List<Integer>> toList() {
            List<List<Integer>> arr = new ArrayList<>();
            arr.add(new ArrayList<>(this.allWinners));
            arr.add(new ArrayList<>(this.oneLosses));
            return arr;
        }
    }
​
    private class DependencyGraph {
        public Vertex[] vertices;
​
        public DependencyGraph(int N) {
            // TODO Auto-generated constructor stub
            this.vertices = new Vertex[N];
        }
    }
​
    private class Vertex {
        public int value;
        public int losses;
​
        public Vertex(int value, int losses) {
            super();
            this.value = value;
            this.losses = losses;
        }
    }
​
    public List<List<Integer>> findWinners(int[][] m) {
        List<MatchInfo> matches = new ArrayList<>();
        for (int[] mm : m) {
            matches.add(new MatchInfo(mm[0], mm[1]));
        }
        DependencyGraph graph = buildDependencyGraph(matches);
        MatchResult matchResult = new MatchResult();
        for (Vertex node : graph.vertices) {
            if (node.losses == 0) {
                matchResult.allWinners.add(node.value);
