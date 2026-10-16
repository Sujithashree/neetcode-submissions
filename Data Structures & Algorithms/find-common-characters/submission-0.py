class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        # Track minimum frequencies across all words for 'a' through 'z'
        min_freq = [float('inf')] * 26
        
        for word in words:
            char_count = [0] * 26
            for ch in word:
                char_count[ord(ch) - ord('a')] += 1
            for i in range(26):
                min_freq[i] = min(min_freq[i], char_count[i])
                
        # Reconstruct the character list
        result = []
        for i in range(26):
            if min_freq[i] > 0:
                result.extend([chr(i + ord('a'))] * min_freq[i])
                
        return result
