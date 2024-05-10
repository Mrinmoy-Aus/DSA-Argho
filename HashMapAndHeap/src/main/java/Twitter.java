import java.util.*;

public class Twitter {
    HashMap<Integer, Set<Integer>> followerMap;
    HashMap<Integer, List<Tweet>> post;

    private class Tweet implements Comparable<Tweet> {
        int tweetId;
        long time;

        Tweet(int tweetId, long time) {
            this.tweetId = tweetId;
            this.time = time;
        }

        @Override
        public int compareTo(Tweet o) {
            return (int) (o.time - this.time);
        }
    }

    public Twitter() {

        this.followerMap = new HashMap<>();
        this.post = new HashMap<>();

    }

    public void postTweet(int userId, int tweetId) {
        List<Tweet> tweets = post.getOrDefault(userId, new ArrayList<>());
        tweets.add(new Tweet(tweetId, System.nanoTime()));
        post.put(userId, tweets);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        Set<Integer> followers = followerMap.getOrDefault(userId, new HashSet<>());

        List<Tweet> userTweets = new ArrayList<>(post.getOrDefault(userId, new ArrayList<>()));
        List<Tweet> followerTweets = new ArrayList<>();
        for (int followee : followers.stream().toList()) {
            List<Tweet> followeeTweets = post.getOrDefault(followee, new ArrayList<>());
            if (followeeTweets.size() != 0)
                followerTweets.addAll(followeeTweets);
        }
        if (followerTweets.size() != 0)
            userTweets.addAll(followerTweets);
        for (Tweet tweets : userTweets) {
            pq.add(tweets);
        }
        List<Integer> feeds = new ArrayList<>();
        int t = 10;
        while (!pq.isEmpty() && t-- > 0) {
            //System.out.println(pq.peek().tweetId);
            feeds.add(pq.remove().tweetId);
        }
        return feeds;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> set = followerMap.getOrDefault(followerId, new HashSet<>());

        set.add(followeeId);
        followerMap.put(followerId, set);

    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followerMap.getOrDefault(followerId, new HashSet<>());

        if (set.contains(followeeId))
            set.remove(followeeId);
        followerMap.put(followerId, set);
    }
}