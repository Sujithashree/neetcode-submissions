class Solution:
    def mySqrt(self, x: int) -> int:

        if x < 2:
            return x

        left = 1
        right = x
        answer = 0

        while left <= right:
            mid = (left + right) // 2

            if mid * mid == x:
                return mid

            elif mid * mid < x:
                # mid is a possible answer
                answer = mid
                left = mid + 1

            else:
                # mid is too large
                right = mid - 1

        return answer