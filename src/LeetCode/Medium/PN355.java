package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class PN355 {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1)); // [5]
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1)); // [6, 5]
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1)); // [5]
    }
}

class Twitter {

    int timestamp = 0;
    HashMap<Integer, List<int[]>> tweets = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> followers = new HashMap<>();

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[] { tweetId, timestamp++ });
    }

    public List<Integer> getNewsFeed(int userId) {

        // The heap arrays will now hold 4 values:
        // Index 0: tweetId
        // Index 1: timestamp (used for sorting)
        // Index 2: userId (so we know whose list to go back to)
        // Index 3: listIndex (so we know exactly which tweet to grab next)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        // Gather the user themselves + everyone they follow into one target group
        HashSet<Integer> targetUsers = new HashSet<>();
        targetUsers.add(userId);
        if (followers.containsKey(userId)) {
            targetUsers.addAll(followers.get(userId));
        }

        // INITIAL BUILD PHASE: Big O of (U log U)
        // "run through all users and take their first recent tweet and add that to the
        // heap"
        for (int uId : targetUsers) {
            if (tweets.containsKey(uId)) {
                List<int[]> userTweets = tweets.get(uId);
                int newestIndex = userTweets.size() - 1; // The most recent tweet is at the very end of the list

                if (newestIndex >= 0) {
                    int[] newestTweet = userTweets.get(newestIndex);
                    // Push: [tweetId, timestamp, userId, listIndex]
                    maxHeap.offer(new int[] { newestTweet[0], newestTweet[1], uId, newestIndex });
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        // EXTRACTION PHASE: Big O of (10 log U)
        // "take a while loop. It would work until the heap is empty... or you have
        // removed 10 tweets"
        while (!maxHeap.isEmpty() && result.size() < 10) {

            // "get the one with the maximum timestamp"
            int[] current = maxHeap.poll();

            // "add that to our main output array"
            result.add(current[0]);

            int uId = current[2];
            int nextIndex = current[3] - 1; // "go to that user and get its second last tweet"

            // "add that tweet with the older timestamps to our heap"
            if (nextIndex >= 0) {
                int[] nextTweet = tweets.get(uId).get(nextIndex);
                maxHeap.offer(new int[] { nextTweet[0], nextTweet[1], uId, nextIndex });
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }
}
