class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int answer = 0;
        Set<String> bankset = new HashSet<>(Arrays.stream(bank).toList());
        Set<String> computed = new HashSet<>();
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        char[] options = new char[] { 'A', 'C', 'G', 'T' };
​
        queue.offer(start);
        computed.add(start);
​
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String current = queue.poll();
                if (current.equals(end))
                    return answer;
​
                for (char opt : options) {
                    // all characters index in current
                    for (int i = 0; i < current.length(); i++) {
                        StringBuilder neighbour = new StringBuilder(current);
                        neighbour.setCharAt(i, opt);
                        // is this new modified neighnboir in bankset or visited
                        if (!computed.contains(neighbour.toString()) && bankset.contains(neighbour.toString())) {
                            queue.offer(neighbour.toString());
                            computed.add(neighbour.toString());
                        }
                    }
                }
                size--;
            }
            answer++;
        }
        return -1;
    }
}
​
