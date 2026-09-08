class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        from collections import deque

        dq = deque()
        result = []

        for right in range(len(nums)):

            # Remove indices that are outside the window
            while dq and dq[0] <= right - k:
                dq.popleft()

            # Remove smaller elements from the back
            while dq and nums[dq[-1]] <= nums[right]:
                dq.pop()

            # Add current index
            dq.append(right)

            # Window is ready once we have k elements
            if right >= k - 1:
                result.append(nums[dq[0]])

        return result