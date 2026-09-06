# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0

class Solution:
    def guessNumber(self, n: int) -> int:

        left = 1
        right = n

        while left <= right:

            mid = (left + right) // 2

            result = guess(mid)

            if result == 0:
                # We found the picked number
                return mid

            elif result == -1:
                # Our guess is too high
                right = mid - 1

            else:
                # Our guess is too low
                left = mid + 1