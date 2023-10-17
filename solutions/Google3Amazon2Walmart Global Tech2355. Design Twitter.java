// Sounish Nath - 17.10.2023

class Tweet {
    int tweetId;
    int userId;
    int clock;
    
    Tweet(int ti, int ui, int c) {
        tweetId=ti;
        userId=ui;
        clock=c;
    }
}

class User {
    int userId;
    Set<Integer> followees=new HashSet<>();
    LinkedList<Tweet> tweets=new LinkedList<>();
    
    User (int ui) {
        userId=ui;
    }
    
    void publishTweet(int twi, int c) {
        tweets.addLast(new Tweet(twi, userId, c));
        if (tweets.size() > 10) {
            tweets.removeFirst();
        }
    }
}

class Twitter {
    
    private Map<Integer, User> users=new HashMap<>();
    private int clock=0; // monotonically increasing counter;

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
