package com.samjin.design.twitter;

import java.util.*;

public class Twitter {

    private int timeStamp = 0;
    // userId:User
    private HashMap<Integer, User> userMap;

    class Tweet{
        private int id;
        private int time;
        private Tweet next;
        public Tweet(int id){
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }
    class User{
        private int id;
        private HashSet<Integer> follow;
        private Tweet tweetHead;

        public User(int id){
            this.id = id;
            this.follow = new HashSet<>();
            follow(id);
            tweetHead = null;
        }

        // 我follow谁
        public void follow(int id){
            follow.add(id);
        }

        public void unFollow(int id){
            follow.remove(id);
        }

        public void post(int id){
            // 倒着加入
            Tweet tweet = new Tweet(id);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }


    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)) return res;
        // 取出所有他follow的人
        HashSet<Integer> users = userMap.get(userId).follow;
        // 时间从大到小
        PriorityQueue<Tweet> queue = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));

        for(int user : users){
            Tweet tweet = userMap.get(user).tweetHead;
            if(tweet != null){
                queue.offer(tweet);
            }
        }

        int count = 0;
        while(!queue.isEmpty() && count < 10){
            Tweet tweet = queue.poll();
            res.add(tweet.id);
            count++;

            if(tweet.next != null){
                queue.offer(tweet.next);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User user = new User(followerId);
            userMap.put(followerId, user);
        }

        if(!userMap.containsKey(followeeId)){
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }

        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId == followeeId){
            return;
        }
        userMap.get(followerId).unFollow(followeeId);
    }



}
