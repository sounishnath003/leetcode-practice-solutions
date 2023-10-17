        }
    }
}
​
class Twitter {
    
    private Map<Integer, User> users=new HashMap<>();
    private int clock=0; // monotonically increasing counter;
​
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        users.putIfAbsent(userId, new User(userId));
        users.get(userId).publishTweet(tweetId, ++clock);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        users.putIfAbsent(userId, new User(userId));
        
        User user=users.get(userId);
        PriorityQueue<Tweet> pq=new PriorityQueue<>((a,b) -> {
            return b.clock - a.clock; // highest value on TOP ==> Mxheap
        });
        
        for (Tweet tweet : user.tweets) {
            pq.offer(tweet);
        }
        
        // go all of her followees and put their tweets into pq
        for (Integer fId : user.followees) {
            User followee=users.get(fId);
            // grab all of tweets
            for (Tweet tweet : followee.tweets) {
                pq.offer(tweet);
            }
        }
        
        // take the top 10. from pq
        List<Integer> tws=new ArrayList<>();
        for (int i=0; i < 10 && !pq.isEmpty(); i++) {
            tws.add(pq.poll().tweetId);
        }
        
        return tws;
    }
    
    public void follow(int followerId, int followeeId) {
        users.putIfAbsent(followerId, new User(followerId));
        users.putIfAbsent(followeeId, new User(followeeId));
        
        users.get(followerId).followees.add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        users.putIfAbsent(followerId, new User(followerId));
        users.putIfAbsent(followeeId, new User(followeeId));
        
        users.get(followerId).followees.remove(followeeId);
    }
}
​
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
