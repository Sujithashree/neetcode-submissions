import heapq

class MedianFinder:

    def __init__(self):
        self.small = []  # Max heap (lower half)
        self.large = []  # Min heap (upper half)

    def addNum(self, num: int) -> None:
        heapq.heappush(self.small, -num)

        # Ensure every element in small <= every element in large
        if self.large and -self.small[0] > self.large[0]:
            val = -heapq.heappop(self.small)
            heapq.heappush(self.large, val)

        # Balance the heaps
        if len(self.small) > len(self.large) + 1:
            val = -heapq.heappop(self.small)
            heapq.heappush(self.large, val)
        elif len(self.large) > len(self.small):
            val = heapq.heappop(self.large)
            heapq.heappush(self.small, -val)

    def findMedian(self) -> float:
        if len(self.small) > len(self.large):
            return float(-self.small[0])

        return (-self.small[0] + self.large[0]) / 2.0