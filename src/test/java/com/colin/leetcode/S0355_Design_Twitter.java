package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class S0355_Design_Twitter {

    class Twitter {

        Map<Integer, Integer> tweetCache = new LinkedHashMap<>();
        Map<Integer, Set<Integer>> followerCache = new LinkedHashMap<>();

        /** Initialize your data structure here. */
        public Twitter() {

        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            tweetCache.put(tweetId, userId);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> lRet = new ArrayList<>();
            List<Integer> tweets = new ArrayList<>();
            Set<Integer> watch = followerCache.get(userId);
            if (watch == null) {
                watch = new LinkedHashSet<>();
            }
            watch.add(userId);

            for (Map.Entry<Integer, Integer> entry : tweetCache.entrySet()) {
                if (watch.contains(entry.getValue())) {
                    tweets.add(entry.getKey());
                }
            }

            for (int idx = tweets.size() - 1; idx >= 0; idx--) {
                lRet.add(tweets.get(idx));
                if (lRet.size() >= 10) {
                    break;
                }
            }

            return lRet;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            Set<Integer> set = followerCache.get(followerId);

            if (set == null) {
                set = new LinkedHashSet<>();
                followerCache.put(followerId, set);
            }

            set.add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            Set<Integer> set = followerCache.get(followerId);
            if (set != null) {
                set.remove(followeeId);
            }
        }
    }

    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */

    @Test
    public void test_0() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        Assertions.assertEquals(Arrays.asList(5), twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        Assertions.assertEquals(Arrays.asList(6, 5), twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        Assertions.assertEquals(Arrays.asList(5), twitter.getNewsFeed(1));
    }

    @Test
    public void test_1() {
        /**
         * ["Twitter","postTweet","postTweet","getNewsFeed"]
         * [[],[1,5],[1,3],[1]]
         */
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        Assertions.assertEquals(Arrays.asList(3, 5), twitter.getNewsFeed(1));
    }

    protected Integer[][] testWithCommands(String[] commands, Integer[][] values) {
        /**
         * ["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed"]
         * [[],[1,5],[1,3],[1,101],[1,13],[1,10],[1,2],[1,94],[1,505],[1,333],[1,22],[1,11],[1]]
         */
        Twitter twitter = new Twitter();
        for (int idx = 1; idx < commands.length; idx++) {
            switch (commands[idx]) {
                case "postTweet":
                    twitter.postTweet(values[idx][0], values[idx][1]);
                    break;
                case "getNewsFeed":
                    twitter.postTweet(values[idx][0], values[idx][1]);
                    break;
                case "follow":
                    twitter.postTweet(values[idx][0], values[idx][1]);
                    break;
                case "unfollow":
                    twitter.postTweet(values[idx][0], values[idx][1]);
                    break;
            }
        }

        return null;
    }
}
