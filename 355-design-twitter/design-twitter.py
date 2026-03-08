from collections import defaultdict, deque
import heapq

class Twitter:
    def __init__(self):
        self.time = 0
        self.tweets = defaultdict(deque)  # userId -> deque of (time, tweetId)
        self.followMap = defaultdict(set) # userId -> set of followeeIds

    def postTweet(self, userId: int, tweetId: int) -> None:
        # Optimization: We only ever need the 10 most recent tweets per user
        self.tweets[userId].appendleft((self.time, tweetId))
        if len(self.tweets[userId]) > 10:
            self.tweets[userId].pop()
        self.time -= 1 # Use negative time for a min-heap to act like a max-heap

    def getNewsFeed(self, userId: int) -> list[int]:
        res = []
        min_heap = []
        
        # User sees their own tweets + people they follow
        ids_to_check = self.followMap[userId] | {userId}
        
        for uid in ids_to_check:
            if uid in self.tweets:
                # Add the first (newest) tweet of each followee to the heap
                # Format: (timestamp, tweetId, userId, next_tweet_index)
                t_time, t_id = self.tweets[uid][0]
                min_heap.append((t_time, t_id, uid, 1))
        
        heapq.heapify(min_heap)
        
        while min_heap and len(res) < 10:
            t_time, t_id, uid, next_idx = heapq.heappop(min_heap)
            res.append(t_id)
            
            # If this user has more tweets, pull the next one into the heap
            if next_idx < len(self.tweets[uid]):
                n_time, n_id = self.tweets[uid][next_idx]
                heapq.heappush(min_heap, (n_time, n_id, uid, next_idx + 1))
        
        return res

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId != followeeId:
            self.followMap[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        # .discard() is safe even if the ID isn't in the set
        self.followMap[followerId].discard(followeeId)