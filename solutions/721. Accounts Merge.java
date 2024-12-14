
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int N = accounts.size();
        String[][] accs = new String[N][];
        for (int i = 0; i < N; i++) accs[i]=new String[accounts.get(i).size()];
        
        for (int i = 0; i < N; i++) {
            accs[i][0]=accounts.get(i).get(0);
            for (int j = 1; j < accounts.get(i).size(); j++) {
                accs[i][j]=accounts.get(i).get(j);
            }
        }
        
        return accountMerger(N, accs);
    }
    
    public List<List<String>> accountMerger(int N, String[][] accounts) {

        // union find algorithm instance.
        UnionFind uf = new UnionFind(N);
        // building graph.
        HashMap<String, Integer> emailMap = new HashMap<>();
        // iterate over the accounts.
        for (int i = 0; i < accounts.length; i++) {
            String name = accounts[i][0];
            for (int j = 1; j < accounts[i].length; j++) {
                String email = accounts[i][j];
                if (emailMap.containsKey(email)) {
                    uf.unionByRank(i, emailMap.get(email));
                } else {
                    emailMap.put(email, i);
                }
            }
        }

        // store the merged mails.
        List<String> mergedMail[] = new List[N];
        for (int i = 0; i < N; i++) {
            mergedMail[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> kv : emailMap.entrySet()) {
            String email = kv.getKey();
            // we need to find the email's parent node
            // and merge the email into the email's parent node index ith.
            int node = uf.findParent(kv.getValue());
            mergedMail[node].add(email);
        }

        // results.
        List<List<String>> results = new ArrayList<>();

        // iterate over.
        for (int i = 0; i < N; i++) {
            if (mergedMail[i].size() == 0) {
                continue;
            }
            // as mentioned in the querstions
            // we need to send the sorted sequence.
            Collections.sort(mergedMail[i]);
            // temp the index
            List<String> temp = new ArrayList<>();
            // the person's name [i][0]
            temp.add(accounts[i][0]);
            temp.addAll(mergedMail[i]);

            results.add(temp);
        }

        return results;
    }

    private class UnionFind {
        private int[] parentArr;
        private int[] rank;

        public UnionFind(int N) {
            parentArr = new int[N];
            rank = new int[N];

            for (int i = 0; i < N; i++) {
                parentArr[i] = i;
            }
        }

        public int findParent(int u) {
            if (parentArr[u] == u) {
                return u;
            }
            return parentArr[u] = findParent(parentArr[u]);
        }

        public void unionByRank(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

            if (pu == pv) {
                return;
            }

            if (rank[pu] > rank[pv]) {
                parentArr[pv] = pu;
            } else if (rank[pu] < rank[pv]) {
                parentArr[pu] = pv;
            } else {
                parentArr[pv] = pu;
                rank[pu]++;
            }
        }
    }

}
