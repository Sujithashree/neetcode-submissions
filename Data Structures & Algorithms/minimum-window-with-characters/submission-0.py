class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s):
            return ""

        need = {}
        for char in t:
            need[char] = need.get(char, 0) + 1

        window = {}

        left = 0
        have = 0
        needCount = len(need)

        minLength = float("inf")
        minLeft = 0

        for right in range(len(s)):
            char = s[right]

            window[char] = window.get(char, 0) + 1

            # This character now satisfies its required frequency
            if char in need and window[char] == need[char]:
                have += 1

            # Try to shrink the window
            while have == needCount:
                windowLength = right - left + 1

                if windowLength < minLength:
                    minLength = windowLength
                    minLeft = left

                leftChar = s[left]
                window[leftChar] -= 1

                if leftChar in need and window[leftChar] < need[leftChar]:
                    have -= 1

                left += 1

        if minLength == float("inf"):
            return ""

        return s[minLeft:minLeft + minLength]