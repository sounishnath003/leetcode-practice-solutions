class Solution {
    private class MatchInfo {
        int winner;
        int losser;

        public MatchInfo(int winner, int losser) {
            super();
            this.winner = winner;
            this.losser = losser;
        }

        @Override
        public String toString() {
            return "MatchInfo [winner=" + winner + ", losser=" + losser + "]";
        }
    }

    private class MatchResult {
        public List<Integer> allWinners;
        public List<Integer> oneLosses;

        public MatchResult() {
            // TODO Auto-generated constructor stub
            this.allWinners = new ArrayList<>();
            this.oneLosses = new ArrayList<>();
        }

        public List<List<Integer>> toList() {
            List<List<Integer>> arr = new ArrayList<>();
            arr.add(new ArrayList<>(this.allWinners));
            arr.add(new ArrayList<>(this.oneLosses));
            return arr;
        }
    }

    private class DependencyGraph {
        public Vertex[] vertices;

        public DependencyGraph(int N) {
            // TODO Auto-generated constructor stub
            this.vertices = new Vertex[N];
        }
    }

    private class Vertex {
        public int value;
        public int losses;

        public Vertex(int value, int losses) {
            super();
            this.value = value;
            this.losses = losses;
        }
    }

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
            } else if (node.losses == 1) {
                matchResult.oneLosses.add(node.value);
            }
        }

        List<List<Integer>> result = matchResult.toList();
        return result;
    }

    private DependencyGraph buildDependencyGraph(List<MatchInfo> matches) {
        // TODO Auto-generated method stub
        Map<Integer, Integer> map = new TreeMap<>(); // <node, loss>
        for (MatchInfo matchInfo : matches) {
            map.putIfAbsent(matchInfo.winner, 0);
            map.putIfAbsent(matchInfo.losser, 0);
            map.put(matchInfo.losser, map.get(matchInfo.losser) + 1);
        }
        DependencyGraph dp = new DependencyGraph(map.size());
        int index = 0;
        for (Map.Entry<Integer, Integer> kv : map.entrySet()) {
            dp.vertices[index] = new Vertex(kv.getKey(), kv.getValue());
            index++;
        }
        return dp;
    }
}
