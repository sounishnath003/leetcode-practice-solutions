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
​
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
​
        // store the merged mails.
        List<String> mergedMail[] = new List[N];
        for (int i = 0; i < N; i++) {
            mergedMail[i] = new ArrayList<>();
        }
​
        for (Map.Entry<String, Integer> kv : emailMap.entrySet()) {
            String email = kv.getKey();
            // we need to find the email's parent node
            // and merge the email into the email's parent node index ith.
            int node = uf.findParent(kv.getValue());
            mergedMail[node].add(email);
        }
​
        // results.
