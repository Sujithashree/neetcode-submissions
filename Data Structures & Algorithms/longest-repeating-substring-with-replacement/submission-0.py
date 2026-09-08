class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count = {}
        left = 0
        maxFreq = 0
        maxLength = 0

        for right in range(len(s)):
            char = s[right]
            count[char] = count.get(char, 0) + 1

            maxFreq = max(maxFreq, count[char])

            # Too many characters need to be replaced
            while (right - left + 1) - maxFreq > k:
                count[s[left]] -= 1
                left += 1

            maxLength = max(maxLength, right - left + 1)

        return maxLength