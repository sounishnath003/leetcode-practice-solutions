class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int currScore = 0;
        for (int i = 0; i < k; i++) currScore += cardPoints[i];
        int bestScore = currScore;
        for (int i = k - 1, j = cardPoints.length - 1; i >= 0 && j >= 0; i--, j--) {
            currScore += cardPoints[j] - cardPoints[i];
            bestScore = Math.max(currScore, bestScore);
        }
        return bestScore;
    }
    // not fully accepted question : Lagging Corner cases!
    public int maxScore2(int[] cardPoints, int k) {
        Deque<Integer> dequeue = new LinkedList<>();
        for (int x : cardPoints) dequeue.add(x);
        int score = 0;
        if (k == cardPoints.length) {
            for (int x : cardPoints) score += x;
            return score;
        }
        while(dequeue.size() > 0 && k-- > 0) {
            int currScore1 = 0;
            int currScore2 = 0;
            currScore1 += dequeue.peekFirst();
            currScore2 += dequeue.size() > 1 ? dequeue.peekLast() : 0;
            currScore1 += score;
            currScore2 += score;
            if (currScore1 > currScore2) {
                score = currScore1;
                dequeue.pollFirst();
            } else {
                score = currScore2;
                dequeue.pollLast();
            }
        }
        return score;
    }
}
