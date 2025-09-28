import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Problem355 {
    public static void main(String[] args) {
        // Example usage
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1)); // Output: [5]
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1)); // Output: [6, 5]
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1)); // Output: [5]
    }
}

class Twitter {
    Map<Integer, Set<Integer>> userToFollowingsMap; // user to who he/she is following
    Map<Integer, PriorityQueue<Tweet>> userToTweetsMap;
    SeqTime seqTime;

    /** Initialize your data structure here. */
    public Twitter() {
        userToFollowingsMap = new HashMap<>();
        userToTweetsMap = new HashMap<>();
        seqTime = new SeqTime();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        // init the friend map
        Tweet tweet = new Tweet(userId, tweetId, seqTime.getTime());
        Set<Integer> followings = userToFollowingsMap.getOrDefault(userId, new HashSet<>());
        followings.add(userId); // 自己是自己的friend，看自己的twitt
        userToFollowingsMap.put(userId, followings);

        // save the tweet into the tweetmap
        PriorityQueue<Tweet> tweets = userToTweetsMap.getOrDefault(userId, new PriorityQueue<Tweet>(
                (a, b) -> b.time - a.time));
        tweets.offer(tweet);
        userToTweetsMap.put(userId, tweets);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
     * the news feed must be posted by users who the user followed or by the user
     * herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followings = userToFollowingsMap.get(userId);

        if (followings == null || followings.isEmpty()) {
            return new ArrayList<>();
        }

        Map<Integer, PriorityQueue<Tweet>> tweetList = new HashMap<>();
        for (Integer following : followings) {
            PriorityQueue<Tweet> tweets = userToTweetsMap.get(following);
            PriorityQueue<Tweet> top10List = getTop10Tweets(tweets);

            if (!top10List.isEmpty()) {
                tweetList.put(following, top10List);
            }
        }

        return mergeTweets(tweetList);
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followings = userToFollowingsMap.getOrDefault(followerId, new HashSet<>());
        followings.add(followerId); // self follow
        followings.add(followeeId);
        userToFollowingsMap.put(followerId, followings);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        Set<Integer> followings = userToFollowingsMap.getOrDefault(followerId, new HashSet<>());
        followings.remove(followeeId);
        userToFollowingsMap.put(followerId, followings);
    }

    private PriorityQueue<Tweet> getTop10Tweets(PriorityQueue<Tweet> tweets) {

        // most recent at top
        PriorityQueue<Tweet> top10Tweets = new PriorityQueue<Tweet>(
                (a, b) -> b.time - a.time);

        for (int i = 0; i < 10; i++) {
            if (tweets == null || tweets.isEmpty()) {
                break;
            }

            top10Tweets.offer(tweets.poll());
        }

        // push back
        Iterator<Tweet> it = top10Tweets.iterator();
        while (it.hasNext()) {
            tweets.offer(it.next());
        }

        return top10Tweets;
    }

    private List<Integer> mergeTweets(Map<Integer, PriorityQueue<Tweet>> tweetLists) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Tweet> finalPQ = new PriorityQueue<Tweet>(
                (a, b) -> b.time - a.time);

        for (Integer userId : tweetLists.keySet()) {
            PriorityQueue<Tweet> tweets = tweetLists.get(userId);
            Tweet top = tweets.poll();
            // tweetLists.put(userId, tweets);
            finalPQ.offer(top);
        }

        int count = 0;
        while (count < 10 && !tweetLists.isEmpty()) { // similar to question for LC281 k-iterators
            Tweet curr = finalPQ.poll();
            ans.add(curr.twitterId);
            PriorityQueue<Tweet> nextTweetList = tweetLists.get(curr.userId);

            if (!nextTweetList.isEmpty()) {
                finalPQ.offer(nextTweetList.poll());
            } else {
                tweetLists.remove(curr.userId);
            }
            count += 1;
        }

        return ans;
    }
}

class Tweet {
    int twitterId;
    int userId;
    int time;

    public Tweet(int userId, int twitterId, int time) {
        this.userId = userId;
        this.twitterId = twitterId;
        this.time = time;
    }
}

class SeqTime {
    int time;

    public SeqTime() {
        time = 0;
    }

    public int getTime() {
        int curTime = time;
        time += 1; // @note: possible overflow for int
        return curTime;
    }
}