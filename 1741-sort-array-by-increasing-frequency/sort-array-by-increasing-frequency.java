class Solution {
    private class Pair implements Comparable<Pair> {
        int num;
        int freq;

        public int compareTo(Pair o) {
            return (o.freq == this.freq) ? ( o.num - this.num ) : this.freq - o.freq;
        }

        Pair(int n, int f) {
            num=n;
            freq=f;
        }
    };
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        for (int elem : nums) map.put(elem, map.getOrDefault(elem, 0)+1);

        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for (Map.Entry<Integer,Integer> kv : map.entrySet()) {
            pq.offer(new Pair( kv.getKey(), kv.getValue() ));
        }

        int k=0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            for (int c=0; c < p.freq; c++) nums[k++] = p.num;
        }

        return nums;
    }
}