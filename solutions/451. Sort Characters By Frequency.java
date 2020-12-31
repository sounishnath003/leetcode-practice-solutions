class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] carr = s.toCharArray();
        for (Character x : carr) {
            hashMap.put(x, hashMap.getOrDefault(x, 0)+1);
        }
        PriorityQueue<Character> maxheap = new PriorityQueue<>((a, b) -> hashMap.get(b) - hashMap.get(a));
        maxheap.addAll(hashMap.keySet());
        StringBuilder answer = new StringBuilder();
        while(!maxheap.isEmpty()) {
            char curr = maxheap.remove();
            for (int i = 1; i < hashMap.get(curr)+1; i++) {
                answer.append(curr);
            }
        }
        return answer.toString();
    }
}
