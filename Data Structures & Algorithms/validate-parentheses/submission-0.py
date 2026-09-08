class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        pairs = {
            ')': '(',
            '}': '{',
            ']': '['
        }

        for char in s:
            if char in pairs:
                # There must be an opening bracket
                # and it must match
                if not stack or stack[-1] != pairs[char]:
                    return False

                stack.pop()

            else:
                # Opening bracket
                stack.append(char)

        # Stack must be empty
        return len(stack) == 0