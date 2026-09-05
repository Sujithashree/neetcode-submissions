import heapq
from collections import Counter

class Solution:
    def reorganizeString(self, s: str) -> str:
        count = Counter(s)

        # Max heap using negative frequencies
        heap = [(-freq, char) for char, freq in count.items()]
        heapq.heapify(heap)

        result = []
        prev_freq = 0
        prev_char = ""

        while heap:
            freq, char = heapq.heappop(heap)

            # Use current character
            result.append(char)
            freq += 1  # Since freq is negative

            # Put previous character back
            if prev_freq < 0:
                heapq.heappush(heap, (prev_freq, prev_char))

            # Current character becomes previous
            prev_freq = freq
            prev_char = char

        if len(result) != len(s):
            return ""

        return "".join(result)