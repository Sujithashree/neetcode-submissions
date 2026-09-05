import heapq
from collections import defaultdict


class Twitter:

    def __init__(self):
        self.time = 0
        self.tweets = defaultdict(list)
        self.following = defaultdict(set)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweets[userId].append((self.time, tweetId))
        self.time += 1

    def getNewsFeed(self, userId: int) -> List[int]:
        heap = []

        # User's own tweets + tweets from people they follow
        users = self.following[userId] | {userId}

        for user in users:
            if self.tweets[user]:
                time, tweetId = self.tweets[user][-1]

                # Negative time = max heap behavior
                heapq.heappush(
                    heap,
                    (-time, tweetId, user, len(self.tweets[user]) - 1)
                )

        result = []

        while heap and len(result) < 10:
            _, tweetId, user, index = heapq.heappop(heap)
            result.append(tweetId)

            # Add the next older tweet from this user
            if index > 0:
                time, tweetId = self.tweets[user][index - 1]

                heapq.heappush(
                    heap,
                    (-time, tweetId, user, index - 1)
                )

        return result

    def follow(self, followerId: int, followeeId: int) -> None:
        self.following[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.following[followerId].discard(followeeId)