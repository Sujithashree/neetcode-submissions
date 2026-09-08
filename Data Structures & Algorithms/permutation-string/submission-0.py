class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False

        count1 = [0] * 26
        count2 = [0] * 26

        # Count characters in s1
        for char in s1:
            count1[ord(char) - ord('a')] += 1

        windowSize = len(s1)

        for right in range(len(s2)):
            # Add current character
            count2[ord(s2[right]) - ord('a')] += 1

            # Keep window size equal to len(s1)
            if right >= windowSize:
                leftChar = s2[right - windowSize]
                count2[ord(leftChar) - ord('a')] -= 1

            # Check if frequencies match
            if count1 == count2:
                return True

        return False